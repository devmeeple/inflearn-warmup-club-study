package com.group.libraryapp.controller.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;

@RestController
public class UserController {

	// TODO: 2024.04.30 13. 데이터베이스 사용
	private final JdbcTemplate jdbcTemplate;

	public UserController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostMapping("/user")
	public void saveUser(@RequestBody UserCreateRequest request) {
		String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
		// TODO: 2024.04.30 데이터의 변경이 일어남을 나타냄 INSERT, UPDATE, DELETE 에 사용
		jdbcTemplate.update(sql, request.getName(), request.getAge());
	}

	@GetMapping("/user")
	public List<UserResponse> getUsers() {
		String sql = "SELECT * FROM user";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			long id = rs.getLong("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			return new UserResponse(id, name, age);
		});
	}
}
