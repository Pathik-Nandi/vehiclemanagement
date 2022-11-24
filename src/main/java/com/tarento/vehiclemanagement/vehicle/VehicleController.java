package com.tarento.vehiclemanagement.vehicle;


import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/addVehicle")
    public long addVehicle(@RequestBody Vehicle vehicle) {return  vehicleService.addVehicle(vehicle);}

    @GetMapping("/getById/{id}")
    public List<Vehicle> getById(@PathVariable long id){return vehicleService.getById(id);}

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable long id){vehicleService.deleteById(id);}


}
