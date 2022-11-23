package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dao.VehicleDao;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDao vehicleDao;
    @Override
    public long addVehicle(Vehicle vehicle) {
        return vehicleDao.save(vehicle).getV_id();
    }

//    @Override
//    public Optional<Vehicle> getByVehicleId(long v_id) {
//        return vehicleDao.findById(v_id);
//    }

}
