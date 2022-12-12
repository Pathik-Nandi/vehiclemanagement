package com.tarento.vehiclemanagement.vehiclespecification.service;


import com.tarento.vehiclemanagement.exception.NotFoundException;
import com.tarento.vehiclemanagement.vehiclespecification.data.VehicleSpecDao;
import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleSpecServiceImpl implements VehicleSpecService {
    @Autowired
    private Validator validator;

    @Autowired
    private VehicleSpecDao vehicleSpecDao;

    @Override
    public List<VehicleSpec> getVehicleSpec() {
        return null;
    }

    @Override
    public List<VehicleSpec> findVehicleByspecId(long specId) {
        return null;
    }

    @Override
    public List<VehicleSpec> findByspecId(long specId) {
            throw new NotFoundException("404", "Vehicle Spec doesn't exists");
    }

    @Override
    public VehicleSpec getVehicleModelById(long specId) {
        Optional<VehicleSpec> vehicleSpec = vehicleSpecDao.findById(specId);
        VehicleSpec vehicleSpecObj = null;
        if (vehicleSpec.isPresent()) {
            vehicleSpecObj = vehicleSpec.get();
        }
        assert vehicleSpecObj!=null;
        return vehicleSpecObj;
    }

    @Override
    @Transactional
    public long addVehicleSpec(VehicleSpec vehicleSpec) {
        if (vehicleSpecDao.findBySpecId(vehicleSpec.getSpecId()).isEmpty()){
            if (vehicleSpecDao.findById(vehicleSpec.getSpecId()).isPresent()){
                return vehicleSpecDao.save(vehicleSpec).getSpecId();
            }
            else{
                throw new NotFoundException("404","Model_id doesn't exist");
            }
        }
        throw new NotFoundException("Err07","Vehicle already exists with this chassis number");
    }

    @Override
    public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec) {
        vehicleSpecDao.save(vehicleSpec);
        return vehicleSpec;
    }

    @Override
    public void deleteVehicleSpec(long specId) {
        if (vehicleSpecDao.existsById(specId)) {
            vehicleSpecDao.softDelete(specId);
        }
        else{
            throw new NotFoundException("404","VehicleSpec id"+" "+ +specId +" "+ "doesn't exists");
        }
    }
}

