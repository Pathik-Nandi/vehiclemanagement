package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;

import java.util.List;
import java.util.Optional;


public interface VehicleService {
  public long addVehicle(Vehicle vehicle);

 public List<Vehicle> getById(long id);

   public void deleteById(long id);
}
