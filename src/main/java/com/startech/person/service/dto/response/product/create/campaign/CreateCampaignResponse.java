package com.startech.person.service.dto.response.product.create.campaign;

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
public class CreateCampaignResponse {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;

    private String name;
    private String code;
    private Boolean active;
}
