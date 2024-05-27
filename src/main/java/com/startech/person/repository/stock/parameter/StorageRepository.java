package com.startech.person.repository.stock.parameter;


import com.startech.person.model.stock.parameter.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StorageRepository extends JpaRepository<Storage, UUID> {
    List<Storage> findAllByActiveTrue();
}
