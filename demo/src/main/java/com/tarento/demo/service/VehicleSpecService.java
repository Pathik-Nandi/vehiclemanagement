package com.tarento.demo.service;

import com.tarento.demo.dto.VehicleSpec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleSpecService {
        List<VehicleSpec> getVehicleSpec();

        //        public List<VehicleSpec> getVehicleSpec();
        public VehicleSpec getVehicleSpecById(long specId);
        public String addVehicleSpec(VehicleSpec vehicleSpec);
        public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec);
        public void deleteVehicleSpec(long specId);


}





