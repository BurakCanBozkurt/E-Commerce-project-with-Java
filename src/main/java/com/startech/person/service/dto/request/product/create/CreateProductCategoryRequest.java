package com.startech.person.service.dto.request.product.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCategoryRequest {
    private String name;
    private String code;
    private UUID parentProductCategory;
    private Boolean active;
}
