package com.startech.person.service.concretes.product;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.product.Product;
import com.startech.person.repository.product.ProductRepository;
import com.startech.person.service.abstracts.product.ProductService;
import com.startech.person.service.dto.request.product.create.CreateProductRequest;
import com.startech.person.service.dto.request.product.update.UpdateProductRequest;
import com.startech.person.service.dto.response.product.create.CreateProductResponse;
import com.startech.person.service.dto.response.product.get.GetAllProductResponse;
import com.startech.person.service.dto.response.product.get.GetProductResponse;
import com.startech.person.service.dto.response.product.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = repository.findAll();
        return products.stream().map(brand -> mapper.forResponse().map(brand, GetAllProductResponse.class)).toList();
    }

    @Override
    public List<GetAllProductResponse> getAllByActiveTrue() {
        List<Product> products = repository.findAllByActiveTrue();
        return products.stream().map(brand -> mapper.forResponse().map(brand, GetAllProductResponse.class)).toList();
    }

    @Override
    public GetProductResponse getById(UUID id) {
        checkIfProductExist(id);
        Product product = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(product, GetProductResponse.class);
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.forRequest().map(request, Product.class);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        repository.save(product);
        return mapper.forResponse().map(product, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(UUID id, UpdateProductRequest request) {
        checkIfProductExist(id);
        Product product = mapper.forRequest().map(request, Product.class);
        product.setId(id);
        product.setCreatedAt(getById(id).getCreatedAt());
        product.setUpdatedAt(new Date());
        repository.save(product);
        return mapper.forResponse().map(product, UpdateProductResponse.class);
    }

    @Override
    public void delete(UUID id) {
        checkIfProductExist(id);
        repository.deleteById(id);

    }

    private void checkIfProductExist(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found Product: " + id.toString()));
    }

}
