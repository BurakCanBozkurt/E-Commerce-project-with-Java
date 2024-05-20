package com.startech.person.service.concretes.user;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.user.Address;
import com.startech.person.repository.user.AddressRepository;
import com.startech.person.service.abstracts.user.AddressService;
import com.startech.person.service.dto.request.user.create.CreateAddressRequest;
import com.startech.person.service.dto.request.user.update.UpdateAddressRequest;
import com.startech.person.service.dto.response.user.create.CreateAddressResponse;
import com.startech.person.service.dto.response.user.get.GetAddressResponse;
import com.startech.person.service.dto.response.user.get.GetAllAddressesResponse;
import com.startech.person.service.dto.response.user.update.UpdateAddressResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService{
	
	private final AddressRepository repository;
	private final ModelMapperService mapper;

	@Override
	public List<GetAllAddressesResponse> getAll() {
		List<Address> addressList = repository.findAll();
		return addressList.stream().map(brand -> mapper.forResponse().map(brand, GetAllAddressesResponse.class)).toList();
	}

	@Override
	public GetAddressResponse getById(UUID id) {
		checkIfUserExists(id);
		Address address = repository.findById(id).orElseThrow();
		return mapper.forResponse().map(address, GetAddressResponse.class);
	}

	@Override
	public CreateAddressResponse add(CreateAddressRequest request) {
		Address address = mapper.forRequest().map(request, Address.class);
		address.setUpdatedAt(new Date());
		repository.save(address);
		return mapper.forResponse().map(address, CreateAddressResponse.class);
	}

	@Override
	public UpdateAddressResponse update(UUID id, UpdateAddressRequest request) {
		checkIfUserExists(id);
		Address address = mapper.forRequest().map(request, Address.class);
		address.setId(id);
		address.setUpdatedAt(new Date());
		repository.save(address);
		return mapper.forResponse().map(address, UpdateAddressResponse.class);
	}

	@Override
	public void delete(UUID id) {
		checkIfUserExists(id);
    repository.deleteById(id);
	}

	private void checkIfUserExists(UUID id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found user: " + id.toString()));
	}
	
}
