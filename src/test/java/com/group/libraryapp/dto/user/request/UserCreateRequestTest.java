package com.group.libraryapp.dto.user.request;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserCreateRequestTest {

	@DisplayName("롬복 기능 테스트")
	@Test
	void checkLombok() {
		// given
		String name = "유재석";
		Integer age = 51;

		// when
		UserCreateRequest dto = new UserCreateRequest(name, age);

		// then
		assertThat(dto.getName()).isEqualTo("유재석");
		assertThat(dto.getAge()).isEqualTo(51);
	}

}
