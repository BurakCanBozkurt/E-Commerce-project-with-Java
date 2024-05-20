package com.startech.person.service.dto.request.user.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGeneralAdvertingRequest {
    private String name;
    private String code;
}
