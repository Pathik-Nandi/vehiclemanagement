package com.tarento.demo.service;

import com.tarento.demo.data.VehicleSpecDao;
import com.tarento.demo.dto.VehicleSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VehicleSpecServiceImpl implements VehicleSpecService {
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
    public void deleteVehicleSpec(long specId) {
        VehicleSpec entity = vehicleSpecDao.getOne(specId);
        vehicleSpecDao.delete(entity);
    }

    @Override
    public VehicleSpec updateVehicleSpec(VehicleSpec vehicleSpec) {
        vehicleSpecDao.save(vehicleSpec);
        return null;
    }

    @Override
    public VehicleSpec addVehicleSpec(VehicleSpec vehicleSpec) {
        vehicleSpecDao.save(vehicleSpec);
        return vehicleSpec;
    }
}
