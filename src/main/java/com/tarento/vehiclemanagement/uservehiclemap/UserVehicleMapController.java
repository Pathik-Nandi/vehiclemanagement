package com.tarento.vehiclemanagement.uservehiclemap;

import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import com.tarento.vehiclemanagement.uservehiclemap.service.UserVehicleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserVehicleMapController {
    @Autowired
    private UserVehicleMapService userVehicleMapService;

    @PostMapping("/adduserVehicleMapping")
    public UserVehicleMap adduserVehicleMapping(@RequestBody UserVehicleMap userVehicleMap){
        return userVehicleMapService.adduserVehicleMapping(userVehicleMap);
    };

    @GetMapping("/getuserVehicleMapping/{userId}")
    public Optional<UserVehicleMap> getuserVehicleMapping(@PathVariable long userId){
        return userVehicleMapService.getuserVehicleMapping(userId);
    };
}
