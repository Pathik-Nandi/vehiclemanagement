package com.tarento.vehiclemanagement.vehiclemodel.data;

import com.tarento.vehiclemanagement.vehiclemodel.dto.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
//@ControllerAdvice
public interface VehicleModelDao extends JpaRepository<VehicleModel, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE vehicle_model set status=0 where model_Id=?1",nativeQuery = true)
    public int softDelete(long modelId);
}
