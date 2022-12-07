package com.tarento.demo.data;

import com.tarento.demo.dto.VehicleSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface VehicleSpecDao extends JpaRepository<VehicleSpec,Long> {
    }
