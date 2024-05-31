package com.startech.person.service.dto.request.product.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductCategoryRequest {
    private UUID id;
    private String name;
    private String code;
    private UUID parentProductCategory;
    private Boolean active;
}
