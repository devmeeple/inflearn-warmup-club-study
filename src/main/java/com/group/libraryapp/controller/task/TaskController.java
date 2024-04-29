package com.group.libraryapp.controller.task;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.task.request.TaskCalcRequest;
import com.group.libraryapp.dto.task.request.TaskSumNumbersRequest;
import com.group.libraryapp.dto.task.response.TaskCalcResponse;
import com.group.libraryapp.dto.task.response.TaskDayOfTheWeekResponse;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

	/**
	 * 문제 1: 두 수를 입력하면, 덧셈, 뺄셈, 곱셈 결과를 반환한다
	 */
	@GetMapping("/calc")
	public TaskCalcResponse calcTwoNumbers(TaskCalcRequest request) {
		return new TaskCalcResponse(
			request.getNum1() + request.getNum2(),
			request.getNum1() - request.getNum2(),
			request.getNum1() * request.getNum2()
		);
	}

	/**
	 * 문제 2: 날짜를 입력하면, 요일을 반환한다
	 */
	@GetMapping("/day-of-the-week")
	public TaskDayOfTheWeekResponse findDayOfTheWeek(
		@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return new TaskDayOfTheWeekResponse(
			date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());
	}

	/**
	 * 문제 3: 여러 수를 받아 총 합을 반환한다
	 * 값을 객체가 아닌 단순 String, Integer 값으로 반환
	 */
	@PostMapping("/sum")
	public Integer sumNumbers(@RequestBody TaskSumNumbersRequest request) {
		// JavaScript reduce 와 유사
		return request.getNumbers().stream().mapToInt(Integer::valueOf).sum();
	}
}
