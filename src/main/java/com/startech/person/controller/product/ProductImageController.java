package com.startech.person.controller.product;


import com.startech.person.service.abstracts.product.ProductImageService;
import com.startech.person.service.dto.response.product.get.ProductImageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("productImage")
public class ProductImageController {

    private ProductImageService service;

    @GetMapping("/getAllByProductId")
    public ResponseEntity<List<ProductImageDto>> getAllByProductId(@RequestParam("productId") UUID productId) {
        return new ResponseEntity<List<ProductImageDto>>(service.getAllByProductId(productId), HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<List<ProductImageDto>> add(@RequestParam("image") List<MultipartFile> imageList,
            @RequestParam("productId") UUID productId) throws IOException {
        return new ResponseEntity<List<ProductImageDto>>(service.add(productId, imageList),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
