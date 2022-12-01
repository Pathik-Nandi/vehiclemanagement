package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;

import java.util.Optional;

public interface VehicleService {
    public Optional<Vehicle> getVehicle(long vehicleId);
}
