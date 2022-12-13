package com.tarento.vehiclemanagement.vehiclemodel.controller;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import com.tarento.vehiclemanagement.vehiclemodel.service.VehicleModelService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    //getting All VehicleModel record by get method
    @GetMapping("/getAllVehicleModel")
    @Timed(value = "greeting.time", description = "Time taken to return greeting")
    public List<VehicleModel> getAllVehicleModel() {
        return vehicleModelService.getVehicleModel();
    }

    //getting particular VehicleModel record by assessmentId
    @GetMapping("/getVehicleModel/{modelId}")
    public VehicleModel getVehicleModelById(@PathVariable Long modelId) {
        return this.vehicleModelService.getVehicleModelById(modelId);
    }

    //Adding VehicleModel by Post method
    @PostMapping("/addVehicleModel")
    @Timed(value = "greeting.time", description = "Time taken to return greeting")
    public APIResponse addVehicleModel(@Valid @RequestBody VehicleModel vehicleModel) {

        return new APIResponse(true, "200", vehicleModelService.addVehicleModel(vehicleModel));
    }

    //Updating VehicleModel record by put method
    @PutMapping("/updateVehicleModel")
    public VehicleModel updateVehicleModel(@RequestBody VehicleModel vehicleModel) {
        return this.vehicleModelService.updateVehicleModel(vehicleModel);
    }

    //Deleting VehicleModel record by delete method
    @DeleteMapping("/deleteVehicleModel/{modelId}")
    public long deleteVehicleModel(@PathVariable Long modelId) {

        return vehicleModelService.deleteVehicleModel(modelId);
    }
}

