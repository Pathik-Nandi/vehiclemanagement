package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;

import java.util.Optional;

public interface UserVehicleMapService {

    public UserVehicleMap adduserVehicleMapping(UserVehicleMap userVehicleMap);
    public Optional<UserVehicleMap> getuserVehicleMapping(long userId);

}
