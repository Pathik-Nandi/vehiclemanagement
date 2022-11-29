package com.tarento.vehiclemanagement.vehicle;


import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/addVehicle")
    public long addVehicle(@RequestBody Vehicle vehicle) {return  vehicleService.addVehicle(vehicle);}

    @GetMapping("/{vehiceId}")
    public Optional<Vehicle> fetchVehicle(@PathVariable long vehicleId){return vehicleService.fetchVehicle(vehicleId);}


    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable long vehicleId){vehicleService.deleteVehicle(vehicleId);}

    @GetMapping("/findByChassisNumber/{chassisNumber}")
    public  List<Vehicle> findBychassisNumber(@PathVariable long chassisNumber){
        return vehicleService.findBychassisNumber(chassisNumber);
    }
}
