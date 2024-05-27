package com.startech.person.service.concretes.stock.parameter;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.stock.parameter.Currency;
import com.startech.person.repository.stock.parameter.CurrencyRepository;
import com.startech.person.service.abstracts.stock.parameter.CurrencyService;
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
public class CurrencyManager implements CurrencyService {
    private CurrencyRepository repository;
    private final ModelMapperService mapper;
    @Override
    public List<GetAllParametersResponse> getAll() {
        List<Currency> currencies=repository.findAll();
        return currencies.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public List<GetAllParametersResponse> getAllByActiveTrue() {
        List<Currency>currencies=repository.findAllByActiveTrue();
        return currencies.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }


    @Override
    public GetParameterResponse getById(UUID id) {
        checkIfCurrencyExist(id);
        Currency currency=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(currency, GetParameterResponse.class);
    }

    @Override
    public CreateParameterResponse add(CreateParameterRequest request) {
        Currency currency=mapper.forRequest().map(request,Currency.class);
        currency.setCreatedAt(new Date());
        currency.setUpdatedAt(new Date());
        repository.save(currency);
        return mapper.forResponse().map(currency, CreateParameterResponse.class);
    }

    @Override
    public UpdateParameterResponse update(UUID id, UpdateParameterRequest request) {
        checkIfCurrencyExist(id);
        Currency currency=mapper.forRequest().map(request,Currency.class);
        currency.setId(id);
        currency.setCreatedAt(getById(id).getCreatedAt());
        currency.setUpdatedAt(new Date());
        repository.save(currency);
        return mapper.forResponse().map(currency, UpdateParameterResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfCurrencyExist(id);
        repository.deleteById(id);
    }
    private void checkIfCurrencyExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Currency: " + id.toString()));
    }
}
