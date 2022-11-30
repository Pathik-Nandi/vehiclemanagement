package com.tarento.vehiclemanagement.vehiclemodel.data;

import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModelRepo extends JpaRepository<VehicleModel, Long> {

}
