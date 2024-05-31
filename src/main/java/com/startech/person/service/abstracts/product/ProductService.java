package com.startech.person.service.abstracts.product;



import com.startech.person.service.dto.request.product.create.CreateProductRequest;
import com.startech.person.service.dto.request.product.update.UpdateProductRequest;
import com.startech.person.service.dto.response.product.create.CreateProductResponse;
import com.startech.person.service.dto.response.product.get.GetAllProductResponse;
import com.startech.person.service.dto.response.product.get.GetProductResponse;
import com.startech.person.service.dto.response.product.update.UpdateProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    List<GetAllProductResponse> getAllByActiveTrue();
    GetProductResponse getById(UUID id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(UUID id, UpdateProductRequest request);
    void delete(UUID id);
}
