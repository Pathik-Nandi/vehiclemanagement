package com.tarento.vehiclemanagement.vehiclespecification.service;

import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VehicleSpecService {
    public List<VehicleSpec> getVehicleSpec();

    List<VehicleSpec> findVehicleByspecId(long specId);

    List<VehicleSpec> findByspecId(long specId);

    public VehicleSpec getVehicleModelById(long specId);

    public String addVehicleSpec(VehicleSpec vehicleSpec) throws IOException, SAXException;

    public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec);

    public void deleteVehicleSpec(long specId);


}





