package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.data.VehicleRepo;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    public Optional<Vehicle> getVehicle(long vehicleId) {
        return vehicleRepo.findById(vehicleId);
    }
}
