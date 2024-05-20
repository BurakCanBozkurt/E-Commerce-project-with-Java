package com.startech.person.service.concretes.user;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.user.User;
import com.startech.person.repository.user.UserRepository;
import com.startech.person.service.abstracts.user.UserService;
import com.startech.person.service.dto.request.user.create.CreateUserRequest;
import com.startech.person.service.dto.request.user.update.UpdateUserRequest;
import com.startech.person.service.dto.response.user.create.CreateUserResponse;
import com.startech.person.service.dto.response.user.get.GetAllUsersResponse;
import com.startech.person.service.dto.response.user.get.GetUserResponse;
import com.startech.person.service.dto.response.user.update.UpdateUserResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
	
	private final UserRepository repository;
	private final ModelMapperService mapper;

	@Override
	public List<GetAllUsersResponse> getAll() {
		List<User> users = repository.findAll();
		return users.stream().map(brand -> mapper.forResponse().map(brand, GetAllUsersResponse.class)).toList();
	}

	@Override
	public GetUserResponse getById(UUID id) {
		checkIfUserExists(id);
		User user = repository.findById(id).orElseThrow();
		return mapper.forResponse().map(user, GetUserResponse.class);
	}

	@Override
	public CreateUserResponse add(CreateUserRequest request) {
		User user = mapper.forRequest().map(request, User.class);
		user.setUpdatedAt(new Date());
		user.setNameSurname(user.getName().toLowerCase() + user.getSurname().toLowerCase());
		repository.save(user);
		return mapper.forResponse().map(user, CreateUserResponse.class);
	}

	@Override
	public UpdateUserResponse update(UUID id, UpdateUserRequest request) {
		checkIfUserExists(id);
		User user = mapper.forRequest().map(request, User.class);
		user.setId(id);
		user.setUpdatedAt(new Date());
		user.setNameSurname(user.getName() + user.getSurname());
		repository.save(user);
		return mapper.forResponse().map(user, UpdateUserResponse.class);
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
