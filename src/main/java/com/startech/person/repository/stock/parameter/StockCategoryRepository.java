package com.startech.person.repository.stock.parameter;


import com.startech.person.model.stock.parameter.StockCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface StockCategoryRepository extends JpaRepository<StockCategory, UUID> {
    List<StockCategory> findAllByActiveTrue();
}
