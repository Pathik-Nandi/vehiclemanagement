package com.tarento.vehiclemanagement.service;

import com.tarento.vehiclemanagement.dto.VehicleModel;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

@Service
public interface VehicleModelService {
    public List<VehicleModel> getVehicleModel();
    public VehicleModel getVehicleModelById(long modelId);
    public String addVehicleModel(VehicleModel vehicleModel) throws IOException, SAXException;
    public VehicleModel updateVehicleModel(VehicleModel vehicleModel);
    public void deleteVehicleModel(long modelId);


}
