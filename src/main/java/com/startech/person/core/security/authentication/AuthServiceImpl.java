package com.startech.person.core.security.authentication;

import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.user.Role;
import com.startech.person.model.user.User;
import com.startech.person.repository.user.RoleRepository;
import com.startech.person.repository.user.UserRepository;
import com.startech.person.security.JwtTokenProvider;
import com.startech.person.service.dto.auth.JWTResponseDto;
import com.startech.person.service.dto.auth.LoginDto;
import com.startech.person.service.dto.request.user.create.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private final ModelMapperService mapper;

    @Override
    public JWTResponseDto login(LoginDto loginDto) {

        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        JWTResponseDto jwtResponseDto=new JWTResponseDto();
        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
            String token = jwtTokenProvider.generateToken(authentication);
            jwtResponseDto.setToken(token);
        }
        return jwtResponseDto;
    }
    @Override
    public ResponseEntity<String> register(CreateUserRequest request) {
        User newUser = mapper.forRequest().map(request, User.class);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setUpdatedAt(new Date());
        newUser.setNameSurname(request.getName().toLowerCase() + request.getSurname().toLowerCase());
        Set<Role> roleSet = new HashSet<>();
        Role role;
        role = roleRepository.findByName("user")
                    .orElseThrow();
        roleSet.add(role);
        newUser.setRole(roleSet);
        User registeredUser = userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully.");

    }
}
