package com.tarento.vehiclemanagement.vehiclespecification.controller;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import com.tarento.vehiclemanagement.vehiclespecification.service.VehicleSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VehicleSpecController {
    @Autowired
    private VehicleSpecService vehicleSpecService;

    @PostMapping("/add")
    public APIResponse addVehicleSpec(@Valid @RequestBody VehicleSpec vehicleSpec) {
        System.out.println(" ");
        long modelId = vehicleSpecService.addVehicleSpec(vehicleSpec);
        return new APIResponse(true, "200", modelId);
    }

    @DeleteMapping("/{modelId}")
    public void deleteVehicleSpec(@PathVariable long modelId) {
        vehicleSpecService.deleteVehicleSpec(modelId);
    }

    @GetMapping("/findByModelId/{modelId}")
    public VehicleSpec findBymodelId(@PathVariable long ModelId) {
        return vehicleSpecService.findVehicleSpecBymodelId(ModelId);
    }
    @PostMapping("/update")
    public APIResponse updateVehicleSpec(@Valid @RequestBody VehicleSpec vehicleSpec) {
        long modelId = vehicleSpecService.updateVehicleSpec(vehicleSpec);
        return new APIResponse(true, "200", modelId);
    }
}
