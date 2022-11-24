package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;

import java.util.List;
import java.util.Optional;

public interface UserVehicleMapService {

    public String adduserVehicleMapping(UserVehicleMap userVehicleMap);
    public Optional<UserVehicleMap> getuserVehicleMapping(long userId);

    public List<UserVehicleMap> getAllUserVehicleMapping(long vehicleId);

    public UserVehicleMap deleteUserVehicleMap(UserVehicleMap userVehicleMap);

}
