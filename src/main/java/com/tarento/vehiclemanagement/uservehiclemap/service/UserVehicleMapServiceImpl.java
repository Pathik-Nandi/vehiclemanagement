package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.uservehiclemap.data.UserVehicleMapDao;
import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import com.tarento.vehiclemanagement.uservehiclemap.exception.CustomException;
import com.tarento.vehiclemanagement.uservehiclemap.exception.NotFoundException;
import com.tarento.vehiclemanagement.vehicle.data.VehicleRepo;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelRepo;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class UserVehicleMapServiceImpl implements UserVehicleMapService {
    @Autowired
    private UserVehicleMapDao userVehicleMapDao;
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private VehicleModelRepo vehicleModelRepo;

    @Value("${vehicleMapServiceImpl.maplimit}")
    private int maplimit;
    @Value("${vehicleMapServiceImpl.yearLimit}")
    private  long yearLimit;

    @Override
    public UserVehicleMap adduserVehicleMapping(UserVehicleMap userVehicleMap) {
        List<UserVehicleMap> userVehicleMapList = getUserVehicleMappingByVehicleId(userVehicleMap.getVehicleId());
        if (userVehicleMapList.size() >= maplimit) {
            throw new CustomException("ERR001", "Mapping limit reached");
        } else {
            Optional<Vehicle> vehicle = vehicleRepo.findById(userVehicleMap.getVehicleId());
            Optional<VehicleModel>  vehicleModel=vehicleModelRepo.findById(vehicle.get().getModel_id());
            if (vehicleModel.get().getManufacturedYear()<yearLimit){
                throw new CustomException("ERR003","Did not meet year requirements ");
            }
            userVehicleMapDao.save(userVehicleMap);
            return userVehicleMap;
        }
    }

    @Override
    public List<UserVehicleMap> getUserVehicleMappingByUserId(long userId) {
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByUserId(userId);
//        if (userVehicleMapList.isEmpty()) {
//            throw new NotFoundException("ERR002", "Mapping not found");
//        }
//        return userVehicleMapList;
        return userVehicleMapDao.findByUserId(userId);
    }

    @Override
    public List<UserVehicleMap> getUserVehicleMappingByVehicleId(long vehicleId) {
//        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByVehicleId(vehicleId);
//        if (userVehicleMapList.isEmpty()) {
//            throw new NotFoundException("ERR002", "Mapping not found");
//        }
//        return userVehicleMapList;
        return userVehicleMapDao.findByVehicleId(vehicleId);
    }

    @Override
    @Transactional
    public UserVehicleMap deleteUserVehicleMap(UserVehicleMap userVehicleMap) {
        userVehicleMapDao.deleteByUserIdAndVehicleId(userVehicleMap.getUserId(), userVehicleMap.getVehicleId());
        return userVehicleMap;
    }
}

