package com.tarento.vehiclemanagement.vehiclespecification.service;


import com.tarento.vehiclemanagement.vehiclespecification.data.VehicleSpecDao;
import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;

@Component
public class VehicleSpecServiceImpl implements VehicleSpecService {
    @Autowired
    private Validator validator;

    @Autowired
    private VehicleSpecDao vehicleSpecDao;
//    @Override
//    public List<VehicleSpec> getVehicleModel() {
//        return vehicleSpecDao.findAll();
//    }

    @Override
    public VehicleSpec getVehicleModelById(long specId) {
        return vehicleSpecDao.findById(specId).get();
    }

    @Override
    public String addVehicleSpec(VehicleSpec vehicleSpec) throws IOException, SAXException {
//        Set<ConstraintViolation<VehicleSpec>> violations = null;
//        validator.validate(vehicleSpec);
//        if (!violations.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (ConstraintViolation<VehicleSpec> constraintViolation : violations) {
//                sb.append(constraintViolation.getMessage());
//            }
//            throw new ConstraintViolationException("Error occurred" + sb.toString(), violations);
//        }
        vehicleSpecDao.save(vehicleSpec);
        return "VehicleModel for " + vehicleSpec.getSpecId() + " Added!";
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

