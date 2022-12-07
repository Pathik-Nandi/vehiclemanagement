package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.exception.NotFoundException;
import com.tarento.vehiclemanagement.exception.ValidationException;
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

//    @Autowired
//    private VehicleModelDao vehicleModelDao;

    @Override
    @Transactional
    public long addVehicle(Vehicle vehicle) {
//        List<Vehicle> vehicleList = findBychassisNumber(vehicle.getChassisNumber());
        if (vehicleDao.findBychassisNumber(vehicle.getChassisNumber()).isEmpty()){
            return vehicleDao.save(vehicle).getVehicleId();
        }
//        return vehicleDao.save(vehicle).getVehicleId();
//        return vehicle.getChassisNumber();
        throw new NotFoundException("Err07","Already exists with this chassis number");
    }

    @Override
    public void deleteVehicle(long vehicleId) {
        vehicleDao.deleteById(vehicleId);
    }

    @Override
    public long updateVehicle(Vehicle vehicle) {
        if (vehicleDao.findBychassisNumber(vehicle.getChassisNumber()).isEmpty()){
            throw new NotFoundException("404","chassis number not found");
        }
        return vehicleDao.save(vehicle).getChassisNumber();

    }

    @Override
    public List<Vehicle> findVehicleBychassisNumber(long chassisNumber) {
        List<Vehicle> chassislist = vehicleDao.findBychassisNumber(chassisNumber);
        if (chassislist.size() > 0) {
            return vehicleDao.findBychassisNumber(chassisNumber);
        } else {
            throw new NotFoundException("404", "chassisnumber doesn't exists");
        }
    }
    @Override
    public Optional<Vehicle> fetchVehicle(long vehicleId) {
        return vehicleDao.findById(vehicleId);
    }
}




