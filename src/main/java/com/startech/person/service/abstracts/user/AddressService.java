package com.startech.person.service.abstracts.user;

import java.util.List;
import java.util.UUID;

import com.startech.person.service.dto.request.user.create.CreateAddressRequest;
import com.startech.person.service.dto.request.user.update.UpdateAddressRequest;
import com.startech.person.service.dto.response.user.create.CreateAddressResponse;
import com.startech.person.service.dto.response.user.get.GetAddressResponse;
import com.startech.person.service.dto.response.user.get.GetAllAddressesResponse;
import com.startech.person.service.dto.response.user.update.UpdateAddressResponse;

public interface AddressService {
	List<GetAllAddressesResponse> getAll();
	GetAddressResponse getById(UUID id);
	CreateAddressResponse add(CreateAddressRequest request);
	UpdateAddressResponse update(UUID id, UpdateAddressRequest request);
	void delete(UUID id);
}
