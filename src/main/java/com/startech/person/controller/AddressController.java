package com.startech.person.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.startech.person.service.abstracts.user.AddressService;
import com.startech.person.service.dto.request.user.create.CreateAddressRequest;
import com.startech.person.service.dto.request.user.update.UpdateAddressRequest;
import com.startech.person.service.dto.response.user.create.CreateAddressResponse;
import com.startech.person.service.dto.response.user.get.GetAddressResponse;
import com.startech.person.service.dto.response.user.get.GetAllAddressesResponse;
import com.startech.person.service.dto.response.user.update.UpdateAddressResponse;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

	private AddressService service;

	@GetMapping("/getAll")
	public List<GetAllAddressesResponse> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<GetAddressResponse> getById(@PathVariable UUID id) {
		return new ResponseEntity<GetAddressResponse>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CreateAddressResponse> save(@RequestBody CreateAddressRequest request) {
		return new ResponseEntity<CreateAddressResponse>(service.add(request), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UpdateAddressResponse> update(@PathVariable UUID id, @RequestBody UpdateAddressRequest request) {
		return new ResponseEntity<UpdateAddressResponse>(service.update(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
