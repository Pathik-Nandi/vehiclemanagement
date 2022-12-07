package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.exception.ValidationException;
import com.tarento.vehiclemanagement.vehicle.data.VehicleDao;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;

    @Override
    @Transactional
    public long addVehicle(Vehicle vehicle) {
        List<Vehicle> vehicleList = findBychassisNumber(vehicle.getChassisNumber());
        if (vehicleList.size() > 0) {
//            throw new RuntimeException("chassis number already exist");
            throw new ValidationException("400", "chassis number already exists");

        }
        return vehicleDao.save(vehicle).getVehicleId();
    }

    @Override
    public void deleteVehicle(long vehicleId) {
        vehicleDao.deleteById(vehicleId);
    }

    @Override
    public List<Vehicle> findBychassisNumber(long chassisNumber) {

        return vehicleDao.findBychassisNumber(chassisNumber);
    }

    @Override
    public Optional<Vehicle> fetchVehicle(long vehicleId) {
        return vehicleDao.findById(vehicleId);
    }
}
