package com.startech.person.service.concretes.stock.parameter;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.stock.parameter.MeasurementUnit;
import com.startech.person.repository.stock.parameter.MeasurementRepository;
import com.startech.person.service.abstracts.stock.parameter.MeasurementUnitService;
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
public class MeasurementUnitManager implements MeasurementUnitService {
    private MeasurementRepository repository;
    private final ModelMapperService mapper;
    @Override
    public List<GetAllParametersResponse> getAll() {
        List<MeasurementUnit>measurementUnits=repository.findAll();
        return measurementUnits.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public List<GetAllParametersResponse> getAllByActiveTrue() {
        List<MeasurementUnit>measurementUnits=repository.findAllByActiveTrue();
        return measurementUnits.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public GetParameterResponse getById(UUID id) {
        checkIfMeasurementUnitExist(id);
        MeasurementUnit measurementUnit=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(measurementUnit,GetParameterResponse.class);
    }

    @Override
    public CreateParameterResponse add(CreateParameterRequest request) {
        MeasurementUnit measurementUnit=mapper.forRequest().map(request,MeasurementUnit.class);
        measurementUnit.setCreatedAt(new Date());
        measurementUnit.setUpdatedAt(new Date());
        repository.save(measurementUnit);
        return mapper.forResponse().map(measurementUnit, CreateParameterResponse.class);
    }

    @Override
    public UpdateParameterResponse update(UUID id, UpdateParameterRequest request) {
        checkIfMeasurementUnitExist(id);
        MeasurementUnit measurementUnit=mapper.forRequest().map(request,MeasurementUnit.class);
        measurementUnit.setId(id);
        measurementUnit.setCreatedAt(getById(id).getCreatedAt());
        measurementUnit.setUpdatedAt(new Date());
        repository.save(measurementUnit);
        return mapper.forResponse().map(measurementUnit, UpdateParameterResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfMeasurementUnitExist(id);
        repository.deleteById(id);
    }

    private void checkIfMeasurementUnitExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Stock Category: " + id.toString()));
    }
}
