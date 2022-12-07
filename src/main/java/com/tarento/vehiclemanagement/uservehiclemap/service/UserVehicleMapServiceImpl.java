package com.tarento.vehiclemanagement.uservehiclemap.service;

import com.tarento.vehiclemanagement.exception.CustomException;
import com.tarento.vehiclemanagement.exception.NotFoundException;
import com.tarento.vehiclemanagement.exception.ValidationException;
import com.tarento.vehiclemanagement.user.dto.User;
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
        User user = userService.getUserById(userVehicleMap.getUserId());
//        if (user == null){
//            throw new CustomException("Err06","User doesn't exist");
//        }
        if (vehicleService.fetchVehicle(userVehicleMap.getUserId()).isEmpty()) {
            throw new CustomException("Err07", "Vehicle doesn't exist");
        }
        List<UserVehicleMap> userVehicleMapList = getUserVehicleMappingByVehicleId(userVehicleMap.getVehicleId());
        if (userVehicleMapList.size() >= maplimit) {
            throw new CustomException("ERR001", "Mapping limit reached");
        } else {
            Optional<Vehicle> vehicle = vehicleRepo.findById(userVehicleMap.getVehicleId());
            Optional<VehicleModel> vehicleModel = vehicleModelRepo.findById(vehicle.get().getModel_id());
            Date manufactureDate = vehicleModel.get().getDateOfManufacture();
            System.out.println(manufactureDate);
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
//        return userVehicleMapDao.findByUserId(userId);
    }

    @Override
    public List<UserVehicleMap> getUserVehicleMappingByVehicleId(long chassisNumber) {
        List<Vehicle> vehicleList = vehicleService.findBychassisNumber(chassisNumber);
        long vehicleId = vehicleList.get(0).getVehicleId();
        List<UserVehicleMap> userVehicleMapList = userVehicleMapDao.findByVehicleId(vehicleId);
        if (userVehicleMapList.isEmpty()) {
            throw new NotFoundException("ERR002", "Mapping not found");
        }
        return userVehicleMapList;
//        return userVehicleMapDao.findByVehicleId(vehicleId);
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

