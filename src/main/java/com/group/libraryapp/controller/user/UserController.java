package com.group.libraryapp.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;

@RestController
public class UserController {

	private final List<User> users = new ArrayList<>();

	@PostMapping("/user")
	public void saveUser(@RequestBody UserCreateRequest request) {
		users.add(new User(request.getName(), request.getAge()));
	}
}
