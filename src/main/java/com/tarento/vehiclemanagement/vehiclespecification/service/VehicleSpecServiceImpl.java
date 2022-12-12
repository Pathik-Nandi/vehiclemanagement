package com.tarento.vehiclemanagement.vehiclespecification.service;


import com.tarento.vehiclemanagement.vehiclespecification.data.VehicleSpecDao;
import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.validation.Validator;
import java.io.IOException;
import java.util.Optional;

@Component
public class VehicleSpecServiceImpl implements VehicleSpecService {
    @Autowired
    private Validator validator;

    @Autowired
    private VehicleSpecDao vehicleSpecDao;

    @Override
    public VehicleSpec getVehicleModelById(long specId) {
        Optional<VehicleSpec> vehicleSpec=vehicleSpecDao.findById(specId);
        VehicleSpec vehicleSpecObj=null;
        if(vehicleSpec.isPresent()){
            vehicleSpecObj=vehicleSpec.get();
        }
        return vehicleSpecObj;
    }

    @Override
    public String addVehicleSpec(VehicleSpec vehicleSpec) throws IOException, SAXException {

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
        Optional<VehicleSpec> entity = vehicleSpecDao.findById(specId);
        VehicleSpec vehicleSpec = null;
        if (entity.isPresent()) {
            vehicleSpec = entity.get();
        }
        assert vehicleSpec != null;
        vehicleSpecDao.delete(vehicleSpec);
    }
}

