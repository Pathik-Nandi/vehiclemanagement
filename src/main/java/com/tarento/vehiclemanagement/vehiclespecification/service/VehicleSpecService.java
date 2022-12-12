package com.tarento.vehiclemanagement.vehiclespecification.service;

import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VehicleSpecService {
     List<VehicleSpec> findByspecId(long specId);

    public VehicleSpec getVehicleModelById(long specId);
    public long addVehicleSpec(VehicleSpec vehicleSpec);
    public long updateVehicleSpec(VehicleSpec vehicleSpec);
    public void deleteVehicleSpec(long specId);
}





