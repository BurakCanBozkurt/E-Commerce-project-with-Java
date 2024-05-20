package com.startech.person.service.concretes.adverting;

import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.adverting.GeneralAdverting;
import com.startech.person.repository.adverting.GeneralAdvertingRepository;
import com.startech.person.service.abstracts.adverting.GeneralAdvertingService;
import com.startech.person.service.dto.request.user.create.CreateGeneralAdvertingRequest;
import com.startech.person.service.dto.request.user.update.UpdateGeneralAdvertingRequest;
import com.startech.person.service.dto.response.user.create.CreateGeneralAdvertingResponse;
import com.startech.person.service.dto.response.user.get.GetGeneralAdvertingResponse;
import com.startech.person.service.dto.response.user.update.UpdateGeneralAdvertingResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GeneralAdvertingManager implements GeneralAdvertingService {
    private GeneralAdvertingRepository repository;
    private final ModelMapperService mapper;


    private void checkIfGeneralAdvertingExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Adverting: " + id.toString()));
    }

    @Override
    public List<GetGeneralAdvertingResponse> getAll() {
        List<GeneralAdverting> generalAdvertingList =repository.findAll();
        return generalAdvertingList.stream().map(brand->mapper.forResponse().map(brand,GetGeneralAdvertingResponse.class)).toList();
    }

    @Override
    public GetGeneralAdvertingResponse getById(UUID id) {
        checkIfGeneralAdvertingExist(id);
        GeneralAdverting generalAdverting=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(generalAdverting,GetGeneralAdvertingResponse.class);
    }

    @Override
    public CreateGeneralAdvertingResponse add(CreateGeneralAdvertingRequest request) {
        GeneralAdverting generalAdverting=mapper.forRequest().map(request,GeneralAdverting.class);
        generalAdverting.setCreatedAt(new Date());
        generalAdverting.setUpdatedAt(new Date());
        repository.save(generalAdverting);
        return mapper.forResponse().map(generalAdverting, CreateGeneralAdvertingResponse.class);
    }

    @Override
    public UpdateGeneralAdvertingResponse update(UUID id, UpdateGeneralAdvertingRequest request) {
        checkIfGeneralAdvertingExist(id);
        GeneralAdverting generalAdverting=mapper.forRequest().map(request,GeneralAdverting.class);
        generalAdverting.setId(id);
        generalAdverting.setCreatedAt(getById(id).getCreatedAt());
        generalAdverting.setUpdatedAt(new Date());
        repository.save(generalAdverting);
        return mapper.forResponse().map(generalAdverting, UpdateGeneralAdvertingResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfGeneralAdvertingExist(id);
        repository.deleteById(id);
    }
}
