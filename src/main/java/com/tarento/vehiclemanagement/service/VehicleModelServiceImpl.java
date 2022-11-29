package com.tarento.vehiclemanagement.service;

import com.tarento.vehiclemanagement.data.VehicleModelDao;
import com.tarento.vehiclemanagement.dto.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.validation.Validator;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Set;


@Component
public class VehicleModelServiceImpl implements VehicleModelService{

    @Autowired
    private Validator validator;
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
    public String addVehicleModel(VehicleModel vehicleModel) throws IOException, SAXException {
        Set<ConstraintViolation<VehicleModel>> violations = validator.validate(vehicleModel);
        if (!violations.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<VehicleModel> constraintViolation : violations){
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred"+sb.toString(), violations);
        }
        vehicleModelDao.save(vehicleModel);
        return "VehicleModel for " + vehicleModel.getModelName() + " Added!";
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
