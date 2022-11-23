package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.uservehiclemap.data.UserVehicleMapDao;
import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserVehicleMapServiceImpl implements UserVehicleMapService{
    @Autowired
    private UserVehicleMapDao userVehicleMapDao;

    @Override
    public UserVehicleMap adduserVehicleMapping(UserVehicleMap userVehicleMap) {
        return userVehicleMapDao.save(userVehicleMap);
    }
    @Override
    public Optional<UserVehicleMap> getuserVehicleMapping(long userId) {
        return userVehicleMapDao.findById(userId);
    }
}
