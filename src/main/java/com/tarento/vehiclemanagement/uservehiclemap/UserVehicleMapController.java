package com.tarento.vehiclemanagement.uservehiclemap;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import com.tarento.vehiclemanagement.uservehiclemap.service.UserVehicleMapService;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/userVehicleMap")
public class UserVehicleMapController {
    Logger logger = LoggerFactory.getLogger(UserVehicleMapController.class);
    @Autowired
    private UserVehicleMapService userVehicleMapService;

    @PostMapping("/add")
    @Timed(value = "add.mapping", description = "Time taken to return add student")
    public APIResponse adduserVehicleMapping(@Valid @RequestBody UserVehicleMap userVehicleMap) {
        logger.info("Entering adding user vehicle mapping");
        UserVehicleMap userVehicleMapResponse = userVehicleMapService.adduserVehicleMapping(userVehicleMap);
        return new APIResponse(true, "200", userVehicleMapResponse);
    }

    @GetMapping("/getByVehicleId/{vehicleId}")
    @Timed(value = "get.mappingByVId", description = "Time taken to get mapping by vehicle id")
    public APIResponse getUserVehicleMapping(@Valid @PathVariable long vehicleId) {
        logger.info("Entering getting user vehicle mapping details by vehicle ID");
        List<UserVehicleMap> userVehicleMapList = userVehicleMapService.getUserVehicleMappingByVehicleId(vehicleId);
        return new APIResponse(true, "200", userVehicleMapList);
    }

    @DeleteMapping("/deleteById")
    @Timed(value = "delete.mapping", description = "Time taken to delete")
    public APIResponse deleteById(@Valid @RequestBody UserVehicleMap userVehicleMap) {
        logger.info("Entering deleting user vehicle mapping");
        UserVehicleMap userVehicleMapResponse = userVehicleMapService.deleteUserVehicleMap(userVehicleMap);
        return new APIResponse(true, "200", userVehicleMapResponse);
    }

    @GetMapping("/getByUserId/{userId}")
    @Timed(value = "get.mappingByUId", description = "Time taken to get mapping by user id")
    public APIResponse getUserVehicleMappingByUserId(@Valid @PathVariable long userId) {
        logger.info("Entering getting user vehicle mapping details by user ID");
        List<UserVehicleMap> userVehicleMapList = userVehicleMapService.getUserVehicleMappingByUserId(userId);
        return new APIResponse(true, "200", userVehicleMapList);
    }

    @GetMapping("/getById/{mapId}")
    @Timed(value = "get.mappingBymapId", description = "Time taken to get mapping by map id")
    public APIResponse getMappingByMapId(@Valid @PathVariable long mapId){
        UserVehicleMap userVehicleMap=userVehicleMapService.findByMapId(mapId);
        return  new APIResponse(true,"200",userVehicleMap);
    }

}
