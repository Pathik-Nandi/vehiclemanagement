package com.tarento.vehiclemanagement.data;

import com.tarento.vehiclemanagement.dto.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModelDao extends JpaRepository<VehicleModel,Long> {
}
