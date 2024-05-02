package com.group.libraryapp.controller.fruit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.libraryapp.dto.fruit.request.AddFruitIRequest;
import com.group.libraryapp.dto.fruit.request.UpdateFruitRequest;

// TODO: 2024.05.03 값은 계속 증가한다. 어떻게 같은 결과를 얻을 수 있을까? Transactional 외에 다른 방법은 없을까?
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class FruitControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@DisplayName("[POST] 과일 정보를 추가한다")
	@Test
	void addFruit() throws Exception {
		// given
		AddFruitIRequest request = new AddFruitIRequest("사과", LocalDate.of(2024, 2, 1), 5000);

		// when
		ResultActions res = mockMvc.perform(post("/api/v1/fruit")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request)));

		// then
		res.andExpect(status().isOk());
	}

	@DisplayName("[PUT] 판매 정보를 업데이트한다")
	@Test
	void updateFruit() throws Exception {
		// given
		UpdateFruitRequest request = new UpdateFruitRequest(1);

		// when
		ResultActions res = mockMvc.perform(put("/api/v1/fruit")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request)));

		// then
		res.andExpect(status().isOk());
	}

	@DisplayName("[GET] 과일이름 을 기준으로, 팔린 금액, 팔리지 않은 금액을 조회한다")
	@Test
	void findByName() throws Exception {
		// given
		String name = "사과";

		// when
		ResultActions res = mockMvc.perform(get("/api/v1/fruit/stat")
			.param("name", name));

		// then
		res.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.salesAmount").value(6000))
			.andExpect(jsonPath("$.notSalesAmount").value(4000));
	}
}
