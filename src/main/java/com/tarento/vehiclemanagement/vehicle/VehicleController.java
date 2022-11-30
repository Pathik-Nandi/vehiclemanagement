package com.tarento.vehiclemanagement.vehicle;

import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getVehicle")
    public Optional<Vehicle> getModelDetails(long vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

}
