package com.tarento.vehiclemanagement.controller;

import com.tarento.vehiclemanagement.dto.APIResponse;
import com.tarento.vehiclemanagement.dto.VehicleModel;
import com.tarento.vehiclemanagement.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    //getting All VehicleModel record by get method
    @GetMapping("/getAllVehicleModel")
    public List<VehicleModel> getAllVehicleModel()
    {
        return vehicleModelService.getVehicleModel();
    }

    //getting particular VehicleModel record by assessmentId
    @GetMapping("/getVehicleModel/{modelId}")
    public VehicleModel getVehicleModelById(@PathVariable Long modelId)
    {
        return this.vehicleModelService.getVehicleModelById(modelId);
    }

    //Adding VehicleModel by Post method
    @PostMapping("/addVehicleModel")
    public APIResponse addVehicleModel(@Valid @RequestBody VehicleModel vehicleModel) {

        return new APIResponse(true,"200",vehicleModelService.addVehicleModel(vehicleModel));
        //return this.vehicleModelService.addVehicleModel(vehicleModel);
    }

    //Updating VehicleModel record by put method
    @PutMapping("/updateVehicleModel")
    public VehicleModel updateVehicleModel(@RequestBody VehicleModel vehicleModel)
    {
        return this.vehicleModelService.updateVehicleModel(vehicleModel);
    }

    //Deleting VehicleModel record by delete method
    @DeleteMapping("/deleteVehicleModel/{modelId}")
    public long deleteVehicleModel(@PathVariable Long modelId){

        return vehicleModelService.deleteVehicleModel(modelId);
    }
}
//    {
//        try {
//            this.vehicleModelService.deleteVehicleModel(Long.parseLong(((modelId))));
//            return new ResponseEntity<>(HttpStatus.OK);
//
//        }catch (Exception e){
//            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
