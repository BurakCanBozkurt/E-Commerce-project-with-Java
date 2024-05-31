package com.startech.person.service.concretes.product;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.product.ProductCategory;
import com.startech.person.repository.product.ProductCategoryRepository;
import com.startech.person.service.abstracts.product.ProductCategoryService;
import com.startech.person.service.dto.request.product.create.CreateProductCategoryRequest;
import com.startech.person.service.dto.request.product.update.UpdateProductCategoryRequest;
import com.startech.person.service.dto.response.product.create.CreateProductCategoryResponse;
import com.startech.person.service.dto.response.product.get.GetAllProductCategoryResponse;
import com.startech.person.service.dto.response.product.get.GetProductCategoryResponse;
import com.startech.person.service.dto.response.product.update.UpdateProductCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryRepository repository;
    private final ModelMapperService mapper;
    @Override
    public List<GetAllProductCategoryResponse> getAll() {
        List<ProductCategory> productCategories=repository.findAll();
        return productCategories.stream().map(brand->mapper.forResponse().map(brand, GetAllProductCategoryResponse.class)).toList();
    }

    @Override
    public List<GetAllProductCategoryResponse> getAllByActiveTrue() {
        List<ProductCategory>productCategories=repository.findAllByActiveTrue();
        return productCategories.stream().map(brand->mapper.forResponse().map(brand,GetAllProductCategoryResponse.class)).toList();
    }

    @Override
    public GetProductCategoryResponse getById(UUID id) {
        checkIfProductCategoryExist(id);
        ProductCategory productCategory=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(productCategory, GetProductCategoryResponse.class);
    }

    @Override
    public CreateProductCategoryResponse add(CreateProductCategoryRequest request) {
        ProductCategory productCategory=mapper.forRequest().map(request,ProductCategory.class);
        productCategory.setCreatedAt(new Date());
        productCategory.setUpdatedAt(new Date());
        repository.save(productCategory);
        return mapper.forResponse().map(productCategory, CreateProductCategoryResponse.class);
    }

    @Override
    public UpdateProductCategoryResponse update(UUID id, UpdateProductCategoryRequest request) {
        checkIfProductCategoryExist(id);
        ProductCategory productCategory=mapper.forRequest().map(request,ProductCategory.class);
        productCategory.setId(id);
        productCategory.setCreatedAt(getById(id).getCreatedAt());
        productCategory.setUpdatedAt(new Date());
        repository.save(productCategory);
        return mapper.forResponse().map(productCategory, UpdateProductCategoryResponse.class);
    }
    @Override
    public void delete(UUID id) {
        checkIfProductCategoryExist(id);
        repository.deleteById(id);
    }
    private void checkIfProductCategoryExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Product Category: " + id.toString()));
    }
}
