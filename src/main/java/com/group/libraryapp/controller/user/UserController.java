package com.group.libraryapp.controller.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
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

	// TODO: 2024.05.01 존재하지 않는 유저를 업데이트, 삭제 요청할 때 어떻게 예외처리할까?
	// TODO: 2024.05.01 jdbcTemplate query(), update()

	/**
	 * 1) 유저를 조회하고 조회에 성공하면 0을 반환
	 * 2) 존재하지 않으면 에러 반환
	 * @param request
	 */
	@PutMapping("/user")
	public void updateUser(@RequestBody UserUpdateRequest request) {
		String readSql = "SELECT * FROM user WHERE id = ?";
		boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();

		if (isUserNotExist) {
			throw new IllegalArgumentException();
		}

		String sql = "UPDATE user SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, request.getName(), request.getId());
	}

	@DeleteMapping("/user")
	public void deleteUser(@RequestParam String name) {
		String readSql = "SELECT * FROM user WHERE name = ?";
		boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();

		if (isUserNotExist) {
			throw new IllegalArgumentException();
		}

		String sql = "DELETE FROM user WHERE name = ?";
		jdbcTemplate.update(sql, name);
	}
}
