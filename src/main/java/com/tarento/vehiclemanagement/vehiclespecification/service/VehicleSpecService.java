package com.tarento.vehiclemanagement.vehiclespecification.service;

import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.stereotype.Service;


@Service
public interface VehicleSpecService {
    public VehicleSpec findVehicleSpecBymodelId(long modelId);
    public long addVehicleSpec(VehicleSpec vehicleSpec);
    public long updateVehicleSpec(VehicleSpec vehicleSpec);
    public void deleteVehicleSpec(long modelId);
}


