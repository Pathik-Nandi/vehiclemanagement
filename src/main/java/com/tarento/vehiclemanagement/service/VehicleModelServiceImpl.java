package com.tarento.vehiclemanagement.service;

import com.tarento.vehiclemanagement.data.VehicleModelDao;
import com.tarento.vehiclemanagement.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VehicleModelServiceImpl implements VehicleModelService{

    @Autowired
    private VehicleModelDao vehicleModelDao;
    @Override
    public List<VehicleModel> getVehicleModel() {
        return vehicleModelDao.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(long modelId) {
        return vehicleModelDao.findById(modelId).get();
    }

    @Override
    public VehicleModel addVehicleModel(VehicleModel vehicleModel) {
        vehicleModelDao.save(vehicleModel);
        return vehicleModel;
    }

    @Override
    public VehicleModel updateVehicleModel(VehicleModel vehicleModel) {
        vehicleModelDao.save(vehicleModel);
        return vehicleModel;
    }

    @Override
    public void deleteVehicleModel(long modelId) {
        VehicleModel entity = vehicleModelDao.getOne(modelId);
        vehicleModelDao.delete(entity);
    }
}
