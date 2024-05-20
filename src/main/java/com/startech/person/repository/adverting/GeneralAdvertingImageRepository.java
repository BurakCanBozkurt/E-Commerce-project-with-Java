package com.startech.person.repository.adverting;

import com.startech.person.model.adverting.GeneralAdvertingImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GeneralAdvertingImageRepository extends JpaRepository<GeneralAdvertingImage, UUID> {

    public List<GeneralAdvertingImage> findAllByGeneralAdverting_Id(UUID productId);
}

