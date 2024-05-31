package com.startech.person.controller.product;


import com.startech.person.service.abstracts.product.ProductService;
import com.startech.person.service.dto.request.product.create.CreateProductRequest;
import com.startech.person.service.dto.request.product.update.UpdateProductRequest;
import com.startech.person.service.dto.response.product.create.CreateProductResponse;
import com.startech.person.service.dto.response.product.get.GetAllProductResponse;
import com.startech.person.service.dto.response.product.get.GetProductResponse;
import com.startech.person.service.dto.response.product.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {

    private ProductService service;

    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/getAllByActiveTrue")
    public List<GetAllProductResponse> getAllByActiveTrue() {
        return service.getAllByActiveTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getById(@PathVariable UUID id) {
        return new ResponseEntity<GetProductResponse>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CreateProductResponse> save(@RequestBody CreateProductRequest request) {
        return new ResponseEntity<CreateProductResponse>(service.add(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductResponse> update(@PathVariable UUID id,
                                                        @RequestBody UpdateProductRequest request) {
        return new ResponseEntity<UpdateProductResponse>(service.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
