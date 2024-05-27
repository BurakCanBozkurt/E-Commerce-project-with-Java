package com.startech.person.service.concretes.stock.parameter;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.stock.parameter.StockCategory;
import com.startech.person.repository.stock.parameter.StockCategoryRepository;
import com.startech.person.service.abstracts.stock.parameter.StockCategoryService;
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
public class StockCategoryManager implements StockCategoryService {

    private StockCategoryRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllParametersResponse> getAll() {
        List<StockCategory>stockCategories=repository.findAll();
        return stockCategories.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public List<GetAllParametersResponse> getAllByActiveTrue() {
        List<StockCategory>stockCategories=repository.findAllByActiveTrue();
        return stockCategories.stream().map(brand->mapper.forResponse().map(brand,GetAllParametersResponse.class)).toList();
    }

    @Override
    public GetParameterResponse getById(UUID id) {
        checkIfStockCategoryExist(id);
        StockCategory stockCategory=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(stockCategory, GetParameterResponse.class);
    }

    @Override
    public CreateParameterResponse add(CreateParameterRequest request) {
        StockCategory stockCategory=mapper.forRequest().map(request,StockCategory.class);
        stockCategory.setCreatedAt(new Date());
        stockCategory.setUpdatedAt(new Date());
        repository.save(stockCategory);
        return mapper.forResponse().map(stockCategory, CreateParameterResponse.class);
    }

    @Override
    public UpdateParameterResponse update(UUID id, UpdateParameterRequest request) {
        checkIfStockCategoryExist(id);
        StockCategory stockCategory=mapper.forRequest().map(request,StockCategory.class);
        stockCategory.setId(id);
        stockCategory.setCreatedAt(getById(id).getCreatedAt());
        stockCategory.setUpdatedAt(new Date());
        repository.save(stockCategory);
        return mapper.forResponse().map(stockCategory, UpdateParameterResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfStockCategoryExist(id);
        repository.deleteById(id);
    }
    private void checkIfStockCategoryExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Stock Category: " + id.toString()));
    }
}
