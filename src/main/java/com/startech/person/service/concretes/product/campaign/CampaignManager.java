package com.startech.person.service.concretes.product.campaign;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.product.campaign.Campaign;
import com.startech.person.repository.product.campaign.CampaignRepository;
import com.startech.person.service.abstracts.product.campaign.CampaignService;
import com.startech.person.service.dto.request.product.create.campaign.CreateCampaignRequest;
import com.startech.person.service.dto.request.product.update.campaign.UpdateCampaignRequest;
import com.startech.person.service.dto.response.product.create.campaign.CreateCampaignResponse;
import com.startech.person.service.dto.response.product.get.campaign.GetAllCampaignResponse;
import com.startech.person.service.dto.response.product.get.campaign.GetCampaignResponse;
import com.startech.person.service.dto.response.product.update.campaign.UpdateCampaignResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CampaignManager implements CampaignService {
    private CampaignRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllCampaignResponse> getAll() {
        List<Campaign> campaigns=repository.findAll();
        return campaigns.stream().map(brand->mapper.forResponse().map(brand, GetAllCampaignResponse.class)).toList();
    }

    @Override
    public List<GetAllCampaignResponse> getAllByActiveTrue() {
        List<Campaign> campaigns=repository.findAllByActiveTrue();
        return campaigns.stream().map(brand->mapper.forResponse().map(brand, GetAllCampaignResponse.class)).toList();
    }

    @Override
    public GetCampaignResponse getById(UUID id) {
        checkIfCampaignExist(id);
        Campaign campaign=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(campaign, GetCampaignResponse.class);
    }

    @Override
    public CreateCampaignResponse add(CreateCampaignRequest request) {
        Campaign campaign=mapper.forRequest().map(request,Campaign.class);
        campaign.setCreatedAt(new Date());
        campaign.setUpdatedAt(new Date());
        repository.save(campaign);
        return mapper.forResponse().map(campaign, CreateCampaignResponse.class);
    }

    @Override
    public UpdateCampaignResponse update(UUID id, UpdateCampaignRequest request) {
        checkIfCampaignExist(id);
        Campaign campaign=mapper.forRequest().map(request,Campaign.class);
        campaign.setId(id);
        campaign.setCreatedAt(getById(id).getCreatedAt());
        campaign.setUpdatedAt(new Date());
        repository.save(campaign);
        return mapper.forResponse().map(campaign, UpdateCampaignResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfCampaignExist(id);
        repository.deleteById(id);
    }
    private void checkIfCampaignExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Campaign: " + id.toString()));
    }
}
