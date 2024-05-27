package com.startech.person.service.dto.request.stock.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateParameterRequest {
    private UUID id;
    private String name;
    private String code;
    private Boolean active;
}
