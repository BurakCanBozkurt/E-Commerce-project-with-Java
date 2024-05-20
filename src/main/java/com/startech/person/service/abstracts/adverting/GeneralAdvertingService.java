package com.startech.person.service.abstracts.adverting;

import com.startech.person.service.dto.request.user.create.CreateGeneralAdvertingRequest;
import com.startech.person.service.dto.request.user.update.UpdateGeneralAdvertingRequest;
import com.startech.person.service.dto.response.user.create.CreateGeneralAdvertingResponse;
import com.startech.person.service.dto.response.user.get.GetGeneralAdvertingResponse;
import com.startech.person.service.dto.response.user.update.UpdateGeneralAdvertingResponse;

import java.util.List;
import java.util.UUID;

public interface GeneralAdvertingService {
    List<GetGeneralAdvertingResponse> getAll();
    GetGeneralAdvertingResponse getById(UUID id);
    CreateGeneralAdvertingResponse add(CreateGeneralAdvertingRequest request);
    UpdateGeneralAdvertingResponse update(UUID id, UpdateGeneralAdvertingRequest request);
    void delete(UUID id);


}
