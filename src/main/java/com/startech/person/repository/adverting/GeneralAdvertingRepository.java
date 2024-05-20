package com.startech.person.repository.adverting;

import com.startech.person.model.adverting.GeneralAdverting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeneralAdvertingRepository extends JpaRepository<GeneralAdverting, UUID> {
}
