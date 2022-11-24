package com.tarento.vehiclemanagement.service;

import com.tarento.vehiclemanagement.dto.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    public List<VehicleModel> getVehicleModel();
    public VehicleModel getVehicleModelById(long modelId);
    public  VehicleModel addVehicleModel(VehicleModel vehicleModel);
    public VehicleModel updateVehicleModel(VehicleModel vehicleModel);
    public void deleteVehicleModel(long modelId);

}
