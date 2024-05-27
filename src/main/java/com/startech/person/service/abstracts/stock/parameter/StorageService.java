package com.startech.person.service.abstracts.stock.parameter;

import com.startech.person.service.dto.request.stock.create.CreateParameterRequest;
import com.startech.person.service.dto.request.stock.update.UpdateParameterRequest;
import com.startech.person.service.dto.response.stock.create.CreateParameterResponse;
import com.startech.person.service.dto.response.stock.get.GetAllParametersResponse;
import com.startech.person.service.dto.response.stock.get.GetParameterResponse;
import com.startech.person.service.dto.response.stock.update.UpdateParameterResponse;

import java.util.List;
import java.util.UUID;

public interface StorageService {
    List<GetAllParametersResponse> getAll();
    List<GetAllParametersResponse> getAllByActiveTrue();
    GetParameterResponse getById(UUID id);
    CreateParameterResponse add(CreateParameterRequest request);
    UpdateParameterResponse update(UUID id, UpdateParameterRequest request);
    void delete(UUID id);

}
