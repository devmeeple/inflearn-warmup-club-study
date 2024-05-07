package com.group.libraryapp.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;

@RestController
public class UserController {

	// TODO: 2024.04.30 13. 데이터베이스 사용
	private final UserServiceV1 userServiceV1;

	public UserController(UserServiceV1 userServiceV1) {
		this.userServiceV1 = userServiceV1;
	}

	@PostMapping("/user")
	public void saveUser(@RequestBody UserCreateRequest request) {
		userServiceV1.saveUser(request);
	}

	@GetMapping("/user")
	public List<UserResponse> getUsers() {
		return userServiceV1.getUsers();
	}

	@PutMapping("/user")
	public void updateUser(@RequestBody UserUpdateRequest request) {
		userServiceV1.updateUser(request);
	}

	@DeleteMapping("/user")
	public void deleteUser(@RequestParam String name) {
		userServiceV1.deleteUser(name);
	}
}
