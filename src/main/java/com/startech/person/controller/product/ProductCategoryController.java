package com.startech.person.controller.product;


import com.startech.person.service.abstracts.product.ProductCategoryService;
import com.startech.person.service.dto.request.product.create.CreateProductCategoryRequest;
import com.startech.person.service.dto.request.product.update.UpdateProductCategoryRequest;
import com.startech.person.service.dto.response.product.create.CreateProductCategoryResponse;
import com.startech.person.service.dto.response.product.get.GetAllProductCategoryResponse;
import com.startech.person.service.dto.response.product.get.GetProductCategoryResponse;
import com.startech.person.service.dto.response.product.update.UpdateProductCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("productCategory")
public class ProductCategoryController {
    private ProductCategoryService service;

    @GetMapping("/getAll")
    public List<GetAllProductCategoryResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/getAllByActiveTrue")
    public List<GetAllProductCategoryResponse> getAllByActiveTrue() {
        return service.getAllByActiveTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductCategoryResponse> getById(@PathVariable UUID id) {
        return new ResponseEntity<GetProductCategoryResponse>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateProductCategoryResponse> save(@RequestBody CreateProductCategoryRequest request) {
        return new ResponseEntity<CreateProductCategoryResponse>(service.add(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductCategoryResponse> update(@PathVariable UUID id,
                                                                @RequestBody UpdateProductCategoryRequest request) {
        return new ResponseEntity<UpdateProductCategoryResponse>(service.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
