package com.startech.person.core.security.authentication;

import com.startech.person.service.dto.auth.JWTResponseDto;
import com.startech.person.service.dto.auth.LoginDto;
import com.startech.person.service.dto.request.user.create.CreateUserRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    JWTResponseDto login(LoginDto loginDto);
    ResponseEntity<String> register(CreateUserRequest request);
}
