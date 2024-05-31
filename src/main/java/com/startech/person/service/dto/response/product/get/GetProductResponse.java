package com.startech.person.service.dto.response.product.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {

    private UUID id;
    private Date createdAt;
    private Date updatedAt;

    private UUID stockId;
    private UUID stockCode;
    private String stockName;
    private String stockBrand;
    private String stockMeasurementUnitId;
    private String stockMeasurementUnitName;

    private UUID currencyId;
    private String currencyName;
    private UUID productCategoryId;
    private String productCategoryName;
    private UUID campaignId;
    private String campaignName;

    private String title;
    private String code;
    private float price;
    private float discountRate;
    private String explanation;
    private Boolean active;

}
