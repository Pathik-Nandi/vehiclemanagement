package com.tarento.vehiclemanagement.vehiclespecification.controller;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import com.tarento.vehiclemanagement.vehiclespecification.service.VehicleSpecService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    @GetMapping("/findByModelId/{modelId}")
    @Timed(value = "add vehicleSpec", description = "time taken for adding vehicleSpec")
    public VehicleSpec findBymodelId(@PathVariable long ModelId) {
        return vehicleSpecService.findVehicleSpecBymodelId(ModelId);
    }
    @DeleteMapping("/{modelId}")
    public void deleteVehicleSpec(@PathVariable long modelId) {
        vehicleSpecService.deleteVehicleSpec(modelId);
    }
    @PostMapping("/update")
    public APIResponse updateVehicleSpec(@Valid @RequestBody VehicleSpec vehicleSpec) {
        long modelId = vehicleSpecService.updateVehicleSpec(vehicleSpec);
        return new APIResponse(true, "200", modelId);
    }
}