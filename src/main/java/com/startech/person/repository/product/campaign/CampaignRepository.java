package com.startech.person.repository.product.campaign;


import com.startech.person.model.product.campaign.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
    List<Campaign> findAllByActiveTrue();
}
