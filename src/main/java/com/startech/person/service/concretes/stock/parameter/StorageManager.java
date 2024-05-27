package com.startech.person.service.concretes.stock.parameter;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.stock.parameter.Storage;
import com.startech.person.repository.stock.parameter.StorageRepository;
import com.startech.person.service.abstracts.stock.parameter.StorageService;
import com.startech.person.service.dto.request.stock.create.CreateParameterRequest;
import com.startech.person.service.dto.request.stock.update.UpdateParameterRequest;
import com.startech.person.service.dto.response.stock.create.CreateParameterResponse;
import com.startech.person.service.dto.response.stock.get.GetAllParametersResponse;
import com.startech.person.service.dto.response.stock.get.GetParameterResponse;
import com.startech.person.service.dto.response.stock.update.UpdateParameterResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class StorageManager implements StorageService {
    private StorageRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllParametersResponse> getAll() {
        List<Storage>storages=repository.findAll();
        return storages.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public List<GetAllParametersResponse> getAllByActiveTrue() {
        List<Storage>storages=repository.findAllByActiveTrue();
        return storages.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public GetParameterResponse getById(UUID id) {
        checkIfStorageExist(id);
        Storage storage=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(storage,GetParameterResponse.class);
    }

    @Override
    public CreateParameterResponse add(CreateParameterRequest request) {
        Storage storage=mapper.forRequest().map(request,Storage.class);
        storage.setCreatedAt(new Date());
        storage.setUpdatedAt(new Date());
        repository.save(storage);
        return mapper.forResponse().map(storage, CreateParameterResponse.class);
    }
    @Override
    public UpdateParameterResponse update(UUID id, UpdateParameterRequest request) {
        checkIfStorageExist(id);
        Storage storage=mapper.forRequest().map(request,Storage.class);
        storage.setId(id);
        storage.setCreatedAt(getById(id).getCreatedAt());
        storage.setUpdatedAt(new Date());
        repository.save(storage);
        return mapper.forResponse().map(storage, UpdateParameterResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfStorageExist(id);
        repository.deleteById(id);
    }
    private void checkIfStorageExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Stock Category: " + id.toString()));
    }
}
