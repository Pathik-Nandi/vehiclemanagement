package com.tarento.vehiclemanagement.service;

import com.tarento.vehiclemanagement.dto.VehicleModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleModelService {
    public List<VehicleModel> getVehicleModel();
    public VehicleModel getVehicleModelById(long modelId);
    public VehicleModel addVehicleModel(VehicleModel vehicleModel);
    public VehicleModel updateVehicleModel(VehicleModel vehicleModel);
    public long deleteVehicleModel(long modelId);


}
