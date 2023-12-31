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
//        checking if user with ID exists or not(calling getUserById from userService),exception handled in user service call
        userService.getUserById(userVehicleMap.getUserId());

//        checking if vehicle with ID is present(calling fetchVehicle from vehicleService),exception handled in vehicle service call
        Vehicle vehicleOptional = vehicleService.fetchVehicle(userVehicleMap.getVehicleId());
        long vehicleId = userVehicleMap.getVehicleId();

//        getting list of mappings by passing chassis number
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByVehicleId(vehicleId);

//      checking if mapping is already present
        userVehicleMapList.forEach(userVehicleMap1 -> {
            if (userVehicleMap1.getUserId() == userVehicleMap.getUserId()) {
                throw new CustomException("Err00", "Mapping already present");
            }
        });

//        checking if map limit is exceeded
        if (userVehicleMapList.size() >= maplimit) {
            throw new CustomException("ERR001", "Mapping limit reached");
        } else {
//          getting vehicle model by passing model ID(using find by Id from vehicle Repo)
            Optional<VehicleModel> vehicleModel = vehicleModelRepo.findById(vehicleOptional.getModelId());
            VehicleModel vehicleModelObj = null;
            if (vehicleModel.isPresent()) {
                vehicleModelObj = vehicleModel.get();
            }
            assert vehicleModelObj != null;
            Date manufactureDate = vehicleModelObj.getDateOfManufacture();
            int manufactureYear = findYear(manufactureDate);
            if (manufactureYear < yearLimit) {
                throw new CustomException("ERR003", "Did not meet year requirements ");
            }
            userVehicleMapDao.save(userVehicleMap);
            return userVehicleMap;
        }
    }


    //    get mappings by providing user ID

    @Override
    public List<UserVehicleMap> getUserVehicleMappingByUserId(long userId) {
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByUserId(userId);
        if (userVehicleMapList.isEmpty()) {
            throw new NotFoundException("ERR002", "Mapping not found");
        }
        return userVehicleMapList;
    }


    //    get mappings by providing chassis number
    @Override
    public List<UserVehicleMap> getUserVehicleMappingByVehicleId(long vehicleId) {
        Vehicle vehicleList = vehicleService.fetchVehicle(vehicleId);
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByVehicleId(vehicleId);
        if (userVehicleMapList.isEmpty()) {
            throw new NotFoundException("ERR002", "Mapping not found");
        }
        return userVehicleMapList;
    }

    //    deleting a mapping
    @Override
    @Transactional
    public UserVehicleMap deleteUserVehicleMap(UserVehicleMap userVehicleMap) {
        userVehicleMapDao.deleteByUserIdAndVehicleId(userVehicleMap.getUserId(), userVehicleMap.getVehicleId());
        return userVehicleMap;
    }

    //    finding if a mapping exists or not
    @Override
    public Optional<UserVehicleMap> findByUserIdAndVehicleId(UserVehicleMap userVehicleMap) {
        return userVehicleMapDao.findByUserIdAndVehicleId(userVehicleMap.getUserId(), userVehicleMap.getVehicleId());
    }

    @Override
    public UserVehicleMap findByMapId(long mapId) {
        Optional<UserVehicleMap> userVehicleMapOptional=userVehicleMapDao.findById(mapId);
        if (userVehicleMapOptional.isPresent()){
            UserVehicleMap userVehicleMap=userVehicleMapOptional.get();
            return userVehicleMap;
        }else {
            throw new CustomException("Err 004","No mapping found");
        }
    }

    //  method for finding year from the date
    public int findYear(Date date) {
        int manufactureYear;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            manufactureYear = calendar.get(Calendar.YEAR);//date util

        } catch (Exception ex) {
            throw new ValidationException("Err5", "Incorrect date limit provided");
        }
        return manufactureYear;
    }
}

