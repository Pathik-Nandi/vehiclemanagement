package com.tarento.vehiclemanagement.vehicle;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public APIResponse addVehicle(@Valid @RequestBody Vehicle vehicle) {
        long vehicleId = vehicleService.addVehicle(vehicle);
        return new APIResponse(true, "200", vehicleId);
    }

    @GetMapping("/{vehicleId}")
    public Vehicle fetchVehicle(@PathVariable long vehicleId) {
        return vehicleService.fetchVehicle(vehicleId);
    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }

    @GetMapping("/findByChassisNumber/{chassisNumber}")
    public List<Vehicle> findBychassisNumber(@PathVariable long chassisNumber) {
        return vehicleService.findVehicleBychassisNumber(chassisNumber);
    }

    @PostMapping("/update")
    public APIResponse updateVehicle(@Valid @RequestBody Vehicle vehicle) {
        long chassisNumber = vehicleService.updateVehicle(vehicle);
        return new APIResponse(true, "200", chassisNumber);
    }
}
