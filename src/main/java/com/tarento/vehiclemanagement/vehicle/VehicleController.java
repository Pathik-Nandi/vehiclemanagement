package com.tarento.vehiclemanagement.vehicle;


import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public long addVehicle(@RequestBody Vehicle vehicle)
    {
        return vehicleService.addVehicle(vehicle);
    }

//    @GetMapping("/getByVehicleId/{v_id}")
//    public Optional<Vehicle> getByVehicleId(@PathVariable long v_id){return vehicleService.getByVehicleId(v_id);}

}
