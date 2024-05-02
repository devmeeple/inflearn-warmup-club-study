package com.group.libraryapp.repository.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.group.libraryapp.dto.user.response.UserResponse;

/**
 * SQL을 사용해 실제 데이터베이스와 통신한다
 */
public class UserRepository {

	private final JdbcTemplate jdbcTemplate;

	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void saverUser(String name, Integer age) {
		String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
		jdbcTemplate.update(sql, name, age);
	}

	public List<UserResponse> getUsers() {
		String sql = "SELECT * FROM user";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			long id = rs.getLong("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			return new UserResponse(id, name, age);
		});
	}

	// 유저 정보를 업데이트 한다
	public void updateUserName(String name, long id) {
		String sql = "UPDATE user SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, name, id);
	}

	// TODO: 2024.05.01 jdbcTemplate query(), update()
	// 유저 아이디를 전달받아서 유저가 존재하는지 확인한다
	public boolean isUserNotExist(long id) {
		String readSql = "SELECT * FROM user WHERE id = ?";
		return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
	}

	public void deleteUser(String name) {
		String sql = "DELETE FROM user WHERE name = ?";
		jdbcTemplate.update(sql, name);
	}

	public boolean isUserNotExist(String name) {
		String readSql = "SELECT * FROM user WHERE name = ?";
		return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
	}
}
