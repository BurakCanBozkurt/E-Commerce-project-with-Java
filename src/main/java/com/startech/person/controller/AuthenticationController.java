package com.startech.person.controller;


import com.startech.person.core.security.authentication.AuthService;
import com.startech.person.service.dto.auth.JWTResponseDto;
import com.startech.person.service.dto.auth.LoginDto;
import com.startech.person.service.dto.request.user.create.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CreateUserRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<JWTResponseDto> login(@RequestBody LoginDto loginDto){
        JWTResponseDto result= authService.login(loginDto);
        return ResponseEntity.ok(result);
    }
}
