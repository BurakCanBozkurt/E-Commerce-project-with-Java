package com.startech.person.service.dto.response.product.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductCategoryResponse {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private UUID parentProductCategory;
    private String parentProductCategoryName;

    private String name;
    private String code;
    private Boolean active;
}
