package com.startech.person.service.dto.response.product.get.campaign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCampaignResponse {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;

    private String name;
    private String code;
    private Boolean active;

}
