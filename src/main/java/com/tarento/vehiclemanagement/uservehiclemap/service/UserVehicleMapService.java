package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;

import java.util.List;

public interface UserVehicleMapService {

    public UserVehicleMap adduserVehicleMapping(UserVehicleMap userVehicleMap);

    public List<UserVehicleMap> getUserVehicleMappingByUserId(long userId);

    public List<UserVehicleMap> getUserVehicleMappingByVehicleId(long vehicleId);

    public UserVehicleMap deleteUserVehicleMap(UserVehicleMap userVehicleMap);

}
