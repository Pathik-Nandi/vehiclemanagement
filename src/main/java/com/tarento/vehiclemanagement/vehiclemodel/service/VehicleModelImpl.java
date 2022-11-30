package com.tarento.vehiclemanagement.vehiclemodel.service;

import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelRepo;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleModelImpl implements VehicleModelService {
    @Autowired
    private VehicleModelRepo vehicleModelRepo;

    @Override
    public VehicleModel getModelDetails(long modelId) {
        Optional<VehicleModel> vehicleModelList = vehicleModelRepo.findById(modelId);
        if (vehicleModelList.isPresent()) {
            return vehicleModelList.get();
        }
        return null;
    }
}
