package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.exception.CustomException;
import com.tarento.vehiclemanagement.exception.NotFoundException;
import com.tarento.vehiclemanagement.exception.ValidationException;
import com.tarento.vehiclemanagement.user.service.UserService;
import com.tarento.vehiclemanagement.uservehiclemap.data.UserVehicleMapDao;
import com.tarento.vehiclemanagement.uservehiclemap.dto.UserVehicleMap;
import com.tarento.vehiclemanagement.vehicle.data.VehicleDao;
import com.tarento.vehiclemanagement.vehicle.dto.Vehicle;
import com.tarento.vehiclemanagement.vehicle.service.VehicleService;
import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelDao;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class UserVehicleMapServiceImpl implements UserVehicleMapService {
    @Autowired
    private UserVehicleMapDao userVehicleMapDao;
    @Autowired
    private VehicleDao vehicleRepo;
    @Autowired
    private VehicleModelDao vehicleModelRepo;

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private UserService userService;

    @Value("${vehicleMapServiceImpl.maplimit}")
    private int maplimit;
    @Value("${vehicleMapServiceImpl.yearLimit}")
    private long yearLimit;


    @Override
    public UserVehicleMap adduserVehicleMapping(UserVehicleMap userVehicleMap) {
        if (findByUserIdAndVehicleId(userVehicleMap).isPresent()) {
            throw new CustomException("Err00", "Mapping already present");
        }
        userService.getUserById(userVehicleMap.getUserId());
        Optional<Vehicle> vehicleOptional=vehicleService.fetchVehicle(userVehicleMap.getVehicleId());
        long chassisnumber = 0;
        if(vehicleOptional.isPresent()){
            chassisnumber=vehicleOptional.get().getChassisNumber();
        }
        List<UserVehicleMap> userVehicleMapList = getUserVehicleMappingByVehicleId(chassisnumber);
        if (userVehicleMapList.size() >= maplimit) {
            throw new CustomException("ERR001", "Mapping limit reached");
        } else {
            Optional<Vehicle> vehicle = vehicleRepo.findById(userVehicleMap.getVehicleId());
            Vehicle vehicleObj=null;
            if (vehicle.isPresent()){
                vehicleObj=vehicle.get();
            }
            assert vehicleObj != null;
            Optional<VehicleModel> vehicleModel = vehicleModelRepo.findById(vehicleObj.getModelId());
            VehicleModel vehicleModelObj=null;
            if(vehicleModel.isPresent()){
                vehicleModelObj=vehicleModel.get();
            }
            assert vehicleModelObj != null;
            Date manufactureDate = vehicleModelObj.getDateOfManufacture();
            int manufactureYear;
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(manufactureDate);
                manufactureYear = calendar.get(Calendar.YEAR);

            } catch (Exception ex) {
                throw new ValidationException("Err5", "Incorrect date limit provided");
            }

            if (manufactureYear < yearLimit) {
                throw new CustomException("ERR003", "Did not meet year requirements ");
            }
            userVehicleMapDao.save(userVehicleMap);
            return userVehicleMap;
        }
    }

    @Override
    public List<UserVehicleMap> getUserVehicleMappingByUserId(long userId) {
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByUserId(userId);
        if (userVehicleMapList.isEmpty()) {
            throw new NotFoundException("ERR002", "Mapping not found");
        }
        return userVehicleMapList;
    }

    @Override
    public List<UserVehicleMap> getUserVehicleMappingByVehicleId(long chassisNumber) {
        List<Vehicle> vehicleList = vehicleService.findVehicleBychassisNumber(chassisNumber);
        long vehicleId = vehicleList.get(0).getVehicleId();
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByVehicleId(vehicleId);
        if (userVehicleMapList.isEmpty()) {
            throw new NotFoundException("ERR002", "Mapping not found");
        }
        return userVehicleMapList;
    }

    @Override
    @Transactional
    public UserVehicleMap deleteUserVehicleMap(UserVehicleMap userVehicleMap) {
        userVehicleMapDao.deleteByUserIdAndVehicleId(userVehicleMap.getUserId(), userVehicleMap.getVehicleId());
        return userVehicleMap;
    }

    @Override
    public Optional<UserVehicleMap> findByUserIdAndVehicleId(UserVehicleMap userVehicleMap) {
        return userVehicleMapDao.findByUserIdAndVehicleId(userVehicleMap.getUserId(), userVehicleMap.getVehicleId());
    }
}

