package com.tarento.demo.service;

import com.tarento.demo.dto.VehicleSpec;

import java.util.List;

public interface VehicleSpecService {

        public VehicleSpec getVehicleSpecById(long specId);
        public  VehicleSpec addVehicleSpec(VehicleSpec vehicleSpec);
        public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec);
        public void deleteVehicleSpec(long specId);

}
