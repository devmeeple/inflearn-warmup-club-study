package com.group.libraryapp.dto.fruit.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateFruitRequest {
	private final long id;

	@JsonCreator
	public UpdateFruitRequest(@JsonProperty("id") long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
