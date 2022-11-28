package com.tarento.vehiclemanagement.vehicle;


import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/addVehicle")
    public String addVehicle(@RequestBody Vehicle vehicle) {return  vehicleService.addVehicle(vehicle);}

    @GetMapping("/getById/{vehiceId}")
    public List<Vehicle> getById(@PathVariable long vehicleId){return vehicleService.getById(vehicleId);}

    @DeleteMapping("/deleteById/{vehiceId}")
    public void deleteById(@PathVariable long vehicleId){vehicleService.deleteById(vehicleId);}


}
