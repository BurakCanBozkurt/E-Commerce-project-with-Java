package com.startech.person.repository.stock.parameter;


import com.startech.person.model.stock.parameter.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
    List<Currency> findAllByActiveTrue();
}
