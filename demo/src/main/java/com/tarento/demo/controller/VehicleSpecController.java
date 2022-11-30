package com.tarento.demo.controller;

import com.tarento.demo.dto.VehicleSpec;
import com.tarento.demo.service.VehicleSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class VehicleSpecController {
    @Autowired
    private VehicleSpecService vehicleSpecService;

    //Testing controller
    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }

    //getting particular VehicleSpec record by assessmentId
    @GetMapping("/getVehicleSpec/{specId}")
    public VehicleSpec getVehicleSpecById(@PathVariable Long specId)
    {
        return this.vehicleSpecService.getVehicleModelById(specId);
    }

    //Adding VehicleSpec by Post method
    @PostMapping("/addVehicleSpec")
    public String addVehicleSpec(@Valid @RequestBody VehicleSpec vehicleSpec) throws IOException, SAXException {
        return this.vehicleSpecService.addVehicleSpec(vehicleSpec);
    }

    //Updating VehicleSpec record by put method
    @PutMapping("/updateVehicleSpec")
    public VehicleSpec updateVehicleMSpec(@RequestBody VehicleSpec vehicleSpec)
    {
        return this.vehicleSpecService.updateVehicleSpec(vehicleSpec);
    }

    //Deleting VehicleSpec record by delete method
    @DeleteMapping("/deleteVehicleSpec/{specId}")
    public ResponseEntity<HttpStatus> deleteVehicleSpec(@PathVariable String modelId)
    {
        try {
            this.vehicleSpecService.deleteVehicleSpec(Long.parseLong((modelId)));
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
