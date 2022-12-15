package com.tarento.vehiclemanagement.vehiclemodel.service;
import com.tarento.vehiclemanagement.exception.CustomException;
import com.tarento.vehiclemanagement.vehiclemodel.data.VehicleModelDao;
import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Optional<VehicleModel> VM = vehicleModelDao.findById(modelId);
        if (VM.isEmpty()){
            throw new CustomException("ERROR:400","model is not found!");
        }
        return VM.get();
    }
    @Override
    @Transactional
    public VehicleModel addVehicleModel(VehicleModel vehicleModel) {
         if (vehicleModelDao.existsById(vehicleModel.getModelId())) {
            throw new CustomException("ERROR:400", "model already exit");
        }
         else {
            vehicleModelDao.save(vehicleModel);
        }
        return vehicleModel;
    }

    @Override
    public VehicleModel updateVehicleModel(VehicleModel vehicleModel) {
         if (vehicleModelDao.existsById(vehicleModel.getModelId())) {
            vehicleModelDao.save(vehicleModel);
        }else {
            throw new CustomException("ERROR:400", "model doesn't exit!!");
        }
        return vehicleModel;
    }

    @Override
    public long deleteVehicleModel(long modelId) {
        vehicleModelDao.delete(modelId);
        return modelId;
    }
}
