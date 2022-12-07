package com.tarento.vehiclemanagement.vehiclemodel.controller;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import com.tarento.vehiclemanagement.vehiclemodel.service.VehicleModelService;
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
    public List<VehicleModel> getAllVehicleModel() {
        return vehicleModelService.getVehicleModel();
    }

    //getting particular VehicleModel record by assessmentId
    @GetMapping("/getVehicleModel/{modelId}")
    public VehicleModel getVehicleModelById(@Valid @PathVariable Long modelId) {
        return this.vehicleModelService.getVehicleModelById(modelId);
    }

    //Adding VehicleModel by Post method
    @PostMapping("/addVehicleModel")
    public APIResponse addVehicleModel(@Valid @RequestBody VehicleModel vehicleModel) {

        return new APIResponse(true, "200", vehicleModelService.addVehicleModel(vehicleModel));
        //return this.vehicleModelService.addVehicleModel(vehicleModel);
    }

    //Updating VehicleModel record by put method
    @PutMapping("/updateVehicleModel")
    public VehicleModel updateVehicleModel(@Valid @RequestBody VehicleModel vehicleModel) {
        return this.vehicleModelService.updateVehicleModel(vehicleModel);
    }

    //Deleting VehicleModel record by delete method
    @DeleteMapping("/deleteVehicleModel/{modelId}")
    public long deleteVehicleModel(@PathVariable Long modelId) {

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
