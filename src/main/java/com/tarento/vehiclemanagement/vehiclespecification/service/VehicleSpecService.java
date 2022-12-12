package com.tarento.vehiclemanagement.vehiclespecification.service;

import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public interface VehicleSpecService {
    public VehicleSpec getVehicleModelById(long specId);

    public String addVehicleSpec(VehicleSpec vehicleSpec) throws IOException, SAXException;

    public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec);

    public void deleteVehicleSpec(long specId);


}





