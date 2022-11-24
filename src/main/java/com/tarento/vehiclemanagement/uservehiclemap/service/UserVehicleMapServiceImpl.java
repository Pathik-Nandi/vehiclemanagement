package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.uservehiclemap.data.UserVehicleMapDao;
import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserVehicleMapServiceImpl implements UserVehicleMapService{
    @Autowired
    private UserVehicleMapDao userVehicleMapDao;

    @Override
    public String adduserVehicleMapping(UserVehicleMap userVehicleMap) {
        List<UserVehicleMap> userVehicleMapList=getAllUserVehicleMapping(userVehicleMap.getVehicleId());
        if (userVehicleMapList.size()>=3){
            return "Cannot add user. Limit Reached!!!";
        }else{
            userVehicleMapDao.save(userVehicleMap);
            return "User with ID : "+userVehicleMap.getUserId()+" mapped to vehicle with ID : "+userVehicleMap.getVehicleId();
        }


    }
    @Override
    public Optional<UserVehicleMap> getuserVehicleMapping(long userId) {
        return userVehicleMapDao.findById(userId);
    }

    @Override
    public List<UserVehicleMap> getAllUserVehicleMapping(long vehicleId) {
        return userVehicleMapDao.findAllByvehicleId(vehicleId);
    }

    @Override
    public UserVehicleMap deleteUserVehicleMap(UserVehicleMap userVehicleMap) {
        userVehicleMapDao.deleteByUserIdAndVehicleId(userVehicleMap.getUserId(), userVehicleMap.getVehicleId());
        return userVehicleMap;
    }
}
