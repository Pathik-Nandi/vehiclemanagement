package com.tarento.demo.service;

import com.tarento.demo.data.VehicleSpecDao;
import com.tarento.demo.dto.VehicleSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.validation.Validator;
import java.util.List;

@Scope("prototype")
@Component
public class VehicleSpecServiceImpl implements VehicleSpecService{

    @Autowired
    private Validator validator;
    @Autowired
    private VehicleSpecDao vehicleSpecDao;
    @Override
    public List<VehicleSpec> getVehicleSpec() {
        return vehicleSpecDao.findAll();
    }

    @Override
    public VehicleSpec getVehicleSpecById(long specId) {
        return vehicleSpecDao.findById(specId).get();
    }


    @Override
    @Transactional
    public String addVehicleSpec(VehicleSpec vehicleSpec){
        vehicleSpecDao.save(vehicleSpec);
//        if(vehicleSpec.getModelId().isEmpty()){
//            throw new ValidationException("400","");
//        }
        return null;
    }

    @Override
    public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec) {
        vehicleSpecDao.save(vehicleSpec);
        return vehicleSpec;
    }

    @Override
    public void deleteVehicleSpec(long specId) {
        VehicleSpec entity = vehicleSpecDao.getOne(specId);
        vehicleSpecDao.delete(entity);
    }
}

