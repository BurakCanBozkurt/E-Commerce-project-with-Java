package com.startech.person.service.dto.request.stock.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateParameterRequest {

    private String name;
    private String code;
    private Boolean active;
}
