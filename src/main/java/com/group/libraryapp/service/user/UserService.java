package com.group.libraryapp.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;

/**
 * 유저가 있는지, 없는지를 확인하고 예외처리를 한다
 */
@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(UserCreateRequest request) {
		userRepository.saverUser(request.getName(), request.getAge());
	}

	public List<UserResponse> getUsers() {
		return userRepository.getUsers();
	}

	// TODO: 2024.05.01 존재하지 않는 유저를 업데이트, 삭제 요청할 때 어떻게 예외처리할까?
	public void updateUser(UserUpdateRequest request) {
		if (userRepository.isUserNotExist(request.getId())) {
			throw new IllegalArgumentException();
		}

		userRepository.updateUserName(request.getName(), request.getId());

	}

	public void deleteUser(String name) {
		if (userRepository.isUserNotExist(name)) {
			throw new IllegalArgumentException();
		}

		userRepository.deleteUser(name);
	}
}
