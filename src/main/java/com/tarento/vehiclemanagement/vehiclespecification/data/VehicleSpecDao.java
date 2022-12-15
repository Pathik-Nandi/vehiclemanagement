package com.tarento.vehiclemanagement.vehiclespecification.data;

import com.tarento.vehiclemanagement.vehiclespecification.dto.VehicleSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehicleSpecDao extends JpaRepository<VehicleSpec, Long> {
    public List<VehicleSpec> findByModelId(long modelId);
    @Modifying
    @Transactional
    @Query(value = "update vehicle set status=0 where vehicle_id=?1",nativeQuery = true)
    public void delete(long modelId);
}
