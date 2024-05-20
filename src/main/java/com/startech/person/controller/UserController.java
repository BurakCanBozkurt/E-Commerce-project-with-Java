package com.startech.person.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.startech.person.service.abstracts.user.UserService;
import com.startech.person.service.dto.request.user.create.CreateUserRequest;
import com.startech.person.service.dto.request.user.update.UpdateUserRequest;
import com.startech.person.service.dto.response.user.create.CreateUserResponse;
import com.startech.person.service.dto.response.user.get.GetAllUsersResponse;
import com.startech.person.service.dto.response.user.get.GetUserResponse;
import com.startech.person.service.dto.response.user.update.UpdateUserResponse;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

	private UserService service;

	@GetMapping("/getAll")
	public List<GetAllUsersResponse> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<GetUserResponse> getUser(@PathVariable UUID id) {
		return new ResponseEntity<GetUserResponse>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CreateUserResponse> save(@RequestBody CreateUserRequest request) {
		return new ResponseEntity<CreateUserResponse>(service.add(request), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable UUID id, @RequestBody UpdateUserRequest request) {
		return new ResponseEntity<UpdateUserResponse>(service.update(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
