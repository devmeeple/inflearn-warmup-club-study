package com.group.libraryapp.dto.task.response;

public class TaskCalcResponse {

	private final int add;
	private final int minus;
	private final int multiply;

	public TaskCalcResponse(int add, int minus, int multiply) {
		this.add = add;
		this.minus = minus;
		this.multiply = multiply;
	}

	public int getAdd() {
		return add;
	}

	public int getMinus() {
		return minus;
	}

	public int getMultiply() {
		return multiply;
	}
}
