package com.tarento.vehiclemanagement.controller;

import com.tarento.vehiclemanagement.dto.VehicleModel;
import com.tarento.vehiclemanagement.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    //Testing controller
    @GetMapping("/home")
    public String home()
    {
        return "This is home page";
    }

    //getting All assessment record by get method
    @GetMapping("/getVehicleModel")
    public List<VehicleModel> getVehicleModel()
    {
        return vehicleModelService.getVehicleModel();
    }

    //getting particular assessment record by assessmentId
    @GetMapping("/getVehicleModel/{modelId}")
    public VehicleModel getVehicleModelById(@PathVariable Long modelId)
    {
        return this.vehicleModelService.getVehicleModelById(modelId);
    }

    //Adding Assessment by Post method
    @PostMapping("/addVehicleModel")
    public VehicleModel addVehicleModel(@RequestBody VehicleModel vehicleModel)
    {
        return this.vehicleModelService.addVehicleModel(vehicleModel);
    }

    //Updating Assessment record by put method
    @PutMapping("/updateVehicleModel")
    public VehicleModel updateVehicleModel(@RequestBody VehicleModel vehicleModel)
    {
        return this.vehicleModelService.updateVehicleModel(vehicleModel);
    }

    //Deleting Assessment record by delete method
    @DeleteMapping("/deleteVehicleModel/{modelId}")
    public ResponseEntity<HttpStatus> deleteVehicleModel(@PathVariable String modelId)
    {
        try {
            this.vehicleModelService.deleteVehicleModel(Long.parseLong((modelId)));
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
