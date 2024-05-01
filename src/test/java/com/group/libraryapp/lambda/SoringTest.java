package com.group.libraryapp.lambda;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열을 사전순으로 정렬한다")
public class SoringTest {

	@DisplayName("익명 클래스를 사용한다")
	@Test
	public void testSortingWithoutLambda() {
		// given
		List<String> teams = Arrays.asList("Bayern Munchen", "Real Madrid", "Paris Saint-Germain", "Borussia Dortmund");

		// when
		Collections.sort(teams, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		// then
		assertThat(teams).containsExactly("Bayern Munchen", "Borussia Dortmund", "Paris Saint-Germain", "Real Madrid");
	}

	@DisplayName("람다를 사용한다")
	@Test
	public void testSortingWithLambda() {
		// given
		List<String> teams = Arrays.asList("Bayern Munchen", "Real Madrid", "Paris Saint-Germain", "Borussia Dortmund");

		// when
		Collections.sort(teams, ((o1, o2) -> o1.compareTo(o2)));

		// then
		assertThat(teams).containsExactly("Bayern Munchen", "Borussia Dortmund", "Paris Saint-Germain", "Real Madrid");
	}

}
