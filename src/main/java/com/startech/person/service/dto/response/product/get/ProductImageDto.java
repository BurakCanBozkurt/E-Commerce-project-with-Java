package com.startech.person.service.dto.response.product.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageDto {
    private UUID id;
    private UUID productId;

    private String path;

    // Getters ve setters
}