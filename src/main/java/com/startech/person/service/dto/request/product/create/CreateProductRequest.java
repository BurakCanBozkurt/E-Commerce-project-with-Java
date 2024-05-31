package com.startech.person.service.dto.request.product.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

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
}
