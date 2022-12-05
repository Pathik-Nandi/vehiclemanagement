package com.tarento.vehiclemanagement.vehiclemodel.service;

import com.tarento.vehiclemanagement.exception.CustomException;
import com.tarento.vehiclemanagement.exception.ValidationException;
import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelDao;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Scope("prototype")
@Component
public class VehicleModelServiceImpl implements VehicleModelService {

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
    @Transactional
    public VehicleModel addVehicleModel(VehicleModel vehicleModel) {
        vehicleModelDao.save(vehicleModel);
        if (vehicleModel.getModelName().isEmpty()) {
            throw new CustomException("400", "null value");
        }
        return vehicleModel;
    }

    @Override
    public VehicleModel updateVehicleModel(VehicleModel vehicleModel) {
        vehicleModelDao.save(vehicleModel);
        return vehicleModel;
    }

    @Override
    public long deleteVehicleModel(long modelId) {
        vehicleModelDao.deleteById(modelId);
        return modelId;
    }
}
