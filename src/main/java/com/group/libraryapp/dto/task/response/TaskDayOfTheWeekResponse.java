package com.group.libraryapp.dto.task.response;

public class TaskDayOfTheWeekResponse {
	private final String dayOfTheWeek;

	public TaskDayOfTheWeekResponse(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
}
