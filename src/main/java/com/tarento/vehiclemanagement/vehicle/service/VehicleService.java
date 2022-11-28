package com.tarento.vehiclemanagement.vehicle.service;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;

import java.util.List;


public interface VehicleService {
  public String addVehicle(Vehicle vehicle);

 public List<Vehicle> getById(long vehicleId);

   public void deleteById(long vehicleId);

   public  List<Vehicle> getAllVehicle(long chassisNumber);
}
