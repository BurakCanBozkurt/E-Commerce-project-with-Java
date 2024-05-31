package com.startech.person.service.abstracts.product;




import com.startech.person.service.dto.request.product.create.CreateProductCategoryRequest;
import com.startech.person.service.dto.request.product.update.UpdateProductCategoryRequest;
import com.startech.person.service.dto.response.product.create.CreateProductCategoryResponse;
import com.startech.person.service.dto.response.product.get.GetAllProductCategoryResponse;
import com.startech.person.service.dto.response.product.get.GetProductCategoryResponse;
import com.startech.person.service.dto.response.product.update.UpdateProductCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface ProductCategoryService {
    List<GetAllProductCategoryResponse> getAll();
    List<GetAllProductCategoryResponse> getAllByActiveTrue();
    GetProductCategoryResponse getById(UUID id);
    CreateProductCategoryResponse add(CreateProductCategoryRequest request);
    UpdateProductCategoryResponse update(UUID id, UpdateProductCategoryRequest request);
    void delete(UUID id);
}
