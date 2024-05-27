package com.startech.person.service.dto.response.stock.get;

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
public class GetStockResponse {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;

    private UUID stockCategoryId;
    private UUID measurementUnitId;
    private UUID currencyId;
    private UUID storageId;

    private String brand;
    private String name;
    private String code;
    private float amount;
    private float unitPrice;
    private float totalPrice;
    private String explanation;
}
