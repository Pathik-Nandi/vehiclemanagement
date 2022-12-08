package com.tarento.vehiclemanagement.uservehiclemap;

import com.tarento.vehiclemanagement.apiresponse.APIResponse;
import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import com.tarento.vehiclemanagement.uservehiclemap.service.UserVehicleMapService;
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
    public APIResponse adduserVehicleMapping(@Valid @RequestBody UserVehicleMap userVehicleMap) {
        logger.info("Entering adding user vehicle mapping");
        UserVehicleMap userVehicleMapResponse = userVehicleMapService.adduserVehicleMapping(userVehicleMap);
        return new APIResponse(true, "200", userVehicleMapResponse);
    }

    @GetMapping("/getByVehicleId/{chassisNumber}")
    public APIResponse getUserVehicleMapping(@Valid @PathVariable long chassisNumber) {
        logger.info("Entering getting user vehicle mapping details by vehicle ID");
        List<UserVehicleMap> userVehicleMapList = userVehicleMapService.getUserVehicleMappingByVehicleId(chassisNumber);
        return new APIResponse(true, "200", userVehicleMapList);
    }

    @DeleteMapping("/deleteById")
    public APIResponse deleteById(@Valid @RequestBody UserVehicleMap userVehicleMap) {
        logger.info("Entering deleting user vehicle mapping");
        UserVehicleMap userVehicleMapResponse = userVehicleMapService.deleteUserVehicleMap(userVehicleMap);
        return new APIResponse(true, "200", userVehicleMapResponse);
    }

    @GetMapping("/getByUserId/{userId}")
    public APIResponse getUserVehicleMappingByUserId(@Valid @PathVariable long userId) {
        logger.info("Entering getting user vehicle mapping details by user ID");
        List<UserVehicleMap> userVehicleMapList = userVehicleMapService.getUserVehicleMappingByUserId(userId);
        return new APIResponse(true, "200", userVehicleMapList);
    }

}
