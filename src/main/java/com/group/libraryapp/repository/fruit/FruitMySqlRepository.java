package com.group.libraryapp.repository.fruit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class FruitMySqlRepository implements FruitRepository {

	private final JdbcTemplate jdbcTemplate;

	public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addFruit(String name, LocalDate warehousingDate, long price) {
		String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, name, warehousingDate, price);
	}

	@Override
	public List<Long> findByName(String name) {
		String sql = "SELECT SUM(price) FROM fruit WHERE name = ? GROUP BY is_sold";
		return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong(1), name);
	}

	@Override
	public boolean isFruitNotExist(long id) {
		String readSql = "SELECT * FROM fruit WHERE id = ?";
		return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
	}

	@Override
	public void updateFruit(long id) {
		String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
