package com.tarento.demo.service;

import com.tarento.demo.dto.VehicleSpec;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

@Service
public interface VehicleSpecService {
//        public List<VehicleSpec> getVehicleSpec();
        public VehicleSpec getVehicleModelById(long specId);
        public String addVehicleSpec(VehicleSpec vehicleSpec) throws IOException, SAXException;
        public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec);
        public void deleteVehicleSpec(long specId);


}





