package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.exception.NotFoundException;
import com.tarento.vehiclemanagement.vehicle.data.VehicleDao;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private VehicleModelDao vehicleModelDao;

    @Override
    @Transactional
    public long addVehicle(Vehicle vehicle) {
        if (vehicleDao.findBychassisNumber(vehicle.getChassisNumber()).isEmpty()) {
            if (vehicleModelDao.findById(vehicle.getModelId()).isPresent()) {
                return vehicleDao.save(vehicle).getVehicleId();
            } else {
                throw new NotFoundException("404", "Model_id doesn't exist");
            }
        } else {
            throw new NotFoundException("Err07", "Vehicle already exists with this chassis number");
        }
    }
    @Override
    public void deleteVehicle(long vehicleId) {
        if (vehicleDao.existsById(vehicleId)) {
            vehicleDao.delete(vehicleId);
        } else {
            throw new NotFoundException("404", "Vehicle id" + " " + +vehicleId + " " + "doesn't exists");
        }
    }
    @Override
    public long updateVehicle(Vehicle vehicle) {
        if (vehicleDao.findById(vehicle.getVehicleId()).isPresent()) {
            return vehicleDao.save(vehicle).getVehicleId();
        } else {
            throw new NotFoundException("404", "vehicle id doesn't exist");
        }
    }

    @Override
    public List<Vehicle> findVehicleBychassisNumber(long chassisNumber) {
        List<Vehicle> chassislist = vehicleDao.findBychassisNumber(chassisNumber);
        if (!chassislist.isEmpty()) {
            return chassislist;
        } else {
            throw new NotFoundException("404", "chassisnumber doesn't exists");
        }
    }
    @Override
    public Vehicle fetchVehicle(long vehicleId) {
        Optional<Vehicle> vehicle = vehicleDao.findById(vehicleId);
        if (vehicle.isPresent()) {
            Vehicle vehiclelist = vehicle.get();
            return vehiclelist;
        } else {
            throw new NotFoundException("404", "Vehicle id:" + vehicleId + " " + "doesn't exist");
        }
    }
}





