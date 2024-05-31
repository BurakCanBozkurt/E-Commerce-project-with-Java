package com.startech.person.service.dto.request.product.update.campaign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignRequest {
    private UUID id;
    private String name;
    private String code;
    private Boolean active;
}
