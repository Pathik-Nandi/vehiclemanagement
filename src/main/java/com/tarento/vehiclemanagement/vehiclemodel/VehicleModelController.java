package com.tarento.vehiclemanagement.vehiclemodel;

import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import com.tarento.vehiclemanagement.vehiclemodel.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicleModel")
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/get/{modelId}")
    public VehicleModel getmodelDetailsById(@PathVariable long modelId) {
        return vehicleModelService.getModelDetails(modelId);
    }

}
