package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
    public long addVehicle(Vehicle vehicle);

    public List<Vehicle> findVehicleBychassisNumber(long chassisNumber);

    public Optional<Vehicle> fetchVehicle(long vehicleId);

    public void deleteVehicle(long vehicleId);

    public long updateVehicle(Vehicle vehicle);
}


