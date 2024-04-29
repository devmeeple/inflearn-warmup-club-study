package com.group.libraryapp.dto.task.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskSumNumbersRequest {

	private final List<Integer> numbers;

	public TaskSumNumbersRequest(@JsonProperty("numbers") List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
