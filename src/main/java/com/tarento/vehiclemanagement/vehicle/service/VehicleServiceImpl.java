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
        if (vehicleDao.findBychassisNumber(vehicle.getChassisNumber()).isEmpty()){
            if (vehicleModelDao.findById(vehicle.getModelId()).isPresent()){
                return vehicleDao.save(vehicle).getVehicleId();
            }
            else{
                throw new NotFoundException("404","Model_id doesn't exist");
            }
        }
        throw new NotFoundException("Err07","Vehicle already exists with this chassis number");
    }
    @Override
    public void deleteVehicle(long vehicleId) {
        if (vehicleDao.existsById(vehicleId)) {
            vehicleDao.softDelete(vehicleId);
        }
        else{
            throw new NotFoundException("404","Vehicle id"+" "+ +vehicleId +" "+ "doesn't exists");
        }
    }
    @Override
    public long updateVehicle(Vehicle vehicle) {
        if (vehicleDao.findBychassisNumber(vehicle.getChassisNumber()).isEmpty()) {
            throw new NotFoundException("404", "chassis number not found");
        }
        else {
            return vehicleDao.save(vehicle).getChassisNumber();
        }
    }

    @Override
    public List<Vehicle> findVehicleBychassisNumber(long chassisNumber) {
        List<Vehicle> chassislist = vehicleDao.findBychassisNumber(chassisNumber);
        if (!chassislist.isEmpty()) {
            return vehicleDao.findBychassisNumber(chassisNumber);
        } else {
            throw new NotFoundException("404", "chassisnumber doesn't exists");
        }
    }
    @Override
    public Optional<Vehicle> fetchVehicle(long vehicleId) {
        if (vehicleDao.existsById(vehicleId)){
            return vehicleDao.findById(vehicleId);
        }
        else{
            throw new NotFoundException("404","Vehicle id:" +vehicleId +" "+"doesn't exist");
        }
    }
}





