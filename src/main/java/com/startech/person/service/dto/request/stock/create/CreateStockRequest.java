package com.startech.person.service.dto.request.stock.create;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStockRequest {

    private UUID stockCategoryId;
    private UUID measurementUnitId;
    private UUID currencyId;
    private UUID storageId;

    private String brand;
    private String name;
    private String code;
    private float amount;
    private float unitPrice;
    private String explanation;
}
