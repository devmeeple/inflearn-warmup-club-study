package com.group.libraryapp.controller.fruit;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.fruit.request.AddFruitIRequest;
import com.group.libraryapp.dto.fruit.request.UpdateFruitRequest;
import com.group.libraryapp.dto.fruit.response.FruitSalesResponse;

@RequestMapping("/api/v1/fruit")
@RestController
public class FruitController {

	private final JdbcTemplate jdbcTemplate;

	public FruitController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostMapping
	public void addFruit(@RequestBody AddFruitIRequest request) {
		// TODO: 2024.05.02 08:57:50 camelCase, snake_case 인지부조화
		String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
	}

	// TODO: 2024.05.02 23:38:58 Body = { JSON } 읽지 못한다. JSON parse error: Cannot construct instance of
	@PutMapping
	public void updateFruit(@RequestBody UpdateFruitRequest request) {
		// TODO: 2024.05.02 09:22:40 어떤 과일정보를 업데이트 할 것인가?
		String readSql = "SELECT * FROM fruit WHERE id = ?";
		boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();

		if (isFruitNotExist) {
			throw new IllegalArgumentException("과일을 찾을 수 없습니다");
		}

		String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
		jdbcTemplate.update(sql, request.getId());
	}

	@GetMapping("/stat")
	public FruitSalesResponse findByName(@RequestParam String name) {
		// TODO: 2024.05.03 요구사항은 합계를 다루고 있다. 조건: 과일 이름, 판매여부를 그룹으로 조회
		String sql = "SELECT SUM(price) FROM fruit WHERE name = ? GROUP BY is_sold";
		List<Long> salesAmounts = jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong(1), name);

		Long salesAmount = salesAmounts.get(0);
		Long notSaleAmount = salesAmounts.get(1);

		return new FruitSalesResponse(salesAmount, notSaleAmount);
	}
}
