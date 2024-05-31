package com.startech.person.service.dto.response.product.create;


import com.startech.person.service.dto.response.product.get.ProductImageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponse {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;

    private UUID stockId;
    private UUID currencyId;
    private UUID productCategoryId;
    private UUID campaignId;

    private String title;
    private String code;
    private float price;
    private float discountRate;
    private String explanation;
    private Boolean active;

    private List<ProductImageDto> images;

}
