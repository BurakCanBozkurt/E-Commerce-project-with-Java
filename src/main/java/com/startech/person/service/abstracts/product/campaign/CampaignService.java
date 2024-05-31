package com.startech.person.service.abstracts.product.campaign;


import com.startech.person.service.dto.request.product.create.campaign.CreateCampaignRequest;
import com.startech.person.service.dto.request.product.update.campaign.UpdateCampaignRequest;
import com.startech.person.service.dto.response.product.create.campaign.CreateCampaignResponse;
import com.startech.person.service.dto.response.product.get.campaign.GetAllCampaignResponse;
import com.startech.person.service.dto.response.product.get.campaign.GetCampaignResponse;
import com.startech.person.service.dto.response.product.update.campaign.UpdateCampaignResponse;

import java.util.List;
import java.util.UUID;

public interface CampaignService {
    List<GetAllCampaignResponse> getAll();
    List<GetAllCampaignResponse> getAllByActiveTrue();
    GetCampaignResponse getById(UUID id);
    CreateCampaignResponse add(CreateCampaignRequest request);
    UpdateCampaignResponse update(UUID id, UpdateCampaignRequest request);
    void delete(UUID id);

}
