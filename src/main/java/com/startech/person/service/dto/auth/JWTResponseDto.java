package com.startech.person.service.dto.auth;

import lombok.Data;

@Data
public class JWTResponseDto {
    private  String token;
    private  String tokenType="Bearer";
}
