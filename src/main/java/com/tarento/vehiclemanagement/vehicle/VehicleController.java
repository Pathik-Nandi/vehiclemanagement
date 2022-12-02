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
    @PostMapping("/add")
    public APIResponse addVehicle(@Valid @RequestBody Vehicle vehicle)
    {
        System.out.println("");
        long vehicleId = vehicleService.addVehicle(vehicle);
        return  new APIResponse(true,"200",vehicleId);
    }
    @GetMapping("/{vehiceId}")
    public Optional<Vehicle> fetchVehicle(@PathVariable long vehicleId) {return vehicleService.fetchVehicle(vehicleId);}
    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable long vehicleId) {vehicleService.deleteVehicle(vehicleId);}
    @GetMapping("/findByChassisNumber/{chassisNumber}")
    public  List<Vehicle> findBychassisNumber(@PathVariable long chassisNumber){return vehicleService.findBychassisNumber(chassisNumber);}
}
