package com.startech.person.service.abstracts.user;

import java.util.List;
import java.util.UUID;

import com.startech.person.service.dto.request.user.create.CreateUserRequest;
import com.startech.person.service.dto.request.user.update.UpdateUserRequest;
import com.startech.person.service.dto.response.user.create.CreateUserResponse;
import com.startech.person.service.dto.response.user.get.GetAllUsersResponse;
import com.startech.person.service.dto.response.user.get.GetUserResponse;
import com.startech.person.service.dto.response.user.update.UpdateUserResponse;

public interface UserService {
	List<GetAllUsersResponse> getAll();
	GetUserResponse getById(UUID id);
	CreateUserResponse add(CreateUserRequest request);
	UpdateUserResponse update(UUID id, UpdateUserRequest request);
	void delete(UUID id);
}
