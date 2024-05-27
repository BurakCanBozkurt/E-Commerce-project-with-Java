package com.startech.person.repository.stock.parameter;

import com.startech.person.model.stock.parameter.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface MeasurementRepository extends JpaRepository<MeasurementUnit, UUID> {
    List<MeasurementUnit> findAllByActiveTrue();
}
