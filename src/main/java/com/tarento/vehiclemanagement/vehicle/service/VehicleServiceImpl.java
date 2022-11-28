package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dao.VehicleDao;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public String addVehicle(Vehicle vehicle) {
        long chassisnumber = vehicle.getChassisNumber();
        List<Vehicle> chassislist = getAllVehicle(chassisnumber);
        for (int i=0; i<chassislist.size();i++) {
            if (chassislist.get(i).getChassisNumber() == chassisnumber) {
                return "chassis number already exist";
            } else {
                vehicleDao.save(vehicle).getVehicleId();
            }

        }
        return "added succesfully";
    }


    @Override
    public List<Vehicle> getById(long vehicleId) {
        return vehicleDao.findById(vehicleId);
    }




    @Override
    public void deleteById(long vehicleId) {
        vehicleDao.deleteById(vehicleId);

    }

    @Override
    public List<Vehicle> getAllVehicle(long chassisNumber) {
        return vehicleDao.findAll();
    }


}
