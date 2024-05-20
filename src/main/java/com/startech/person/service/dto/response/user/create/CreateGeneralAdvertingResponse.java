package com.startech.person.service.dto.response.user.create;

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
public class CreateGeneralAdvertingResponse {

    private UUID id;
    private Date createdAt;
    private Date updatedAt;

    private String name;
    private String code;
}