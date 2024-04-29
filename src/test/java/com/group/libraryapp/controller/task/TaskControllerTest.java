package com.group.libraryapp.controller.task;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.libraryapp.dto.task.request.TaskCalcRequest;
import com.group.libraryapp.dto.task.request.TaskSumNumbersRequest;

@DisplayName("2024-04-30 과제 2")
@WebMvcTest(TaskController.class) // 웹 계층만 테스트하는데 사용
class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc; // HTTP 요청을 mocking, 상태 코드와 본문 검증에 사용

	@Autowired
	private ObjectMapper objectMapper; // JSON 본문 직렬화

	@DisplayName("[문제 1] 덧셈, 뺄셈, 곱셈의 결과를 반환한다")
	@Test
	void calcTwoNumbers() throws Exception {
		// given
		TaskCalcRequest request = new TaskCalcRequest(10, 5);

		// when
		ResultActions res = mockMvc.perform(get("/api/v1/calc")
			.param("num1", String.valueOf(request.getNum1()))
			.param("num2", String.valueOf(request.getNum2())));

		// then
		res.andExpect(status().isOk());
		res.andExpect(jsonPath("$.add").value(15));
		res.andExpect(jsonPath("$.minus").value(5));
		res.andExpect(jsonPath("$.multiply").value(50));
	}

	@DisplayName("[문제 2] 날짜를 입력하면, 해당 요일을 반환한다")
	@Test
	void findDayOfTheWeek() throws Exception {
		// given
		LocalDate date = LocalDate.of(2024, 4, 29);

		// when
		ResultActions res = mockMvc.perform(get("/api/v1/day-of-the-week")
			.param("date", date.toString()));

		// then
		res.andExpect(status().isOk());
		res.andExpect(jsonPath("$.dayOfTheWeek").value("MON"));
	}

	@DisplayName("[문제 3] 여러 수를 받아 총합을 반환한다")
	@Test
	void sumNumbers() throws Exception {
		// given
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		TaskSumNumbersRequest request = new TaskSumNumbersRequest(numbers);

		// when
		ResultActions res = mockMvc.perform(post("/api/v1/sum")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request)));

		// then
		res.andExpect(status().isOk());
		res.andExpect(jsonPath("$").value(15));
	}
}
