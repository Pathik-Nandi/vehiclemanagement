package com.tarento.vehiclemanagement.vehiclespecification.service;


import com.tarento.vehiclemanagement.exception.NotFoundException;
import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelDao;
import com.tarento.vehiclemanagement.vehiclespecification.data.VehicleSpecDao;
import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleSpecServiceImpl implements VehicleSpecService {
    @Autowired
    private VehicleModelDao vehicleModelDao;
    @Autowired
    private VehicleSpecDao vehicleSpecDao;
    @Override
    public VehicleSpec findVehicleSpecBymodelId(long modelId) {
        Optional<VehicleSpec> list = vehicleSpecDao.findById(modelId);
        if (list.isPresent()) {
            VehicleSpec vehicleSpec = list.get();
            return vehicleSpec;
        } else {
            throw new NotFoundException("404", "Model Id doesn't exists");
        }
    }

    @Override
    public long addVehicleSpec(VehicleSpec vehicleSpec) {
        if (vehicleSpecDao.findById(vehicleSpec.getModelId()).isEmpty()){
            return vehicleSpecDao.save(vehicleSpec).getModelId();
        }else {
            throw new NotFoundException("Err07", "Vehicle already exists with this Model Id");
        }
    }
    @Override
    public long updateVehicleSpec(VehicleSpec vehicleSpec) {
        if (vehicleSpecDao.findById(vehicleSpec.getModelId()).isEmpty()) {
            throw new NotFoundException("404", "Model Id not found");
        }
        else {
            return vehicleSpecDao.save(vehicleSpec).getModelId();
        }
    }
    @Override
    public void deleteVehicleSpec(long modelId) {
        if (vehicleSpecDao.existsById(modelId)) {
            vehicleSpecDao.delete(modelId);
        }
        else{
            throw new NotFoundException("404","Model id"+" "+ +modelId +" "+ "doesn't exists");
        }
    }
}
