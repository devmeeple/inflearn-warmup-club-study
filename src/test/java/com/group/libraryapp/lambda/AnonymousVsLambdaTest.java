package com.group.libraryapp.lambda;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("익명클래스와 람다식")
public class AnonymousVsLambdaTest {

	@DisplayName("[익명 클래스] 두 수를 더한다")
	@Test
	public void testAnonymousClass() {
		// given
		MathOperation add = new MathOperation() {
			@Override
			public int operate(int a, int b) {
				return a + b;
			}
		};

		// when
		int result = add.operate(10, 5);

		// then
		assertThat(result).isEqualTo(15);
	}

	@DisplayName("[람다식] 두 수를 더한다")
	@Test
	public void testLambda() {
		// given
		MathOperation add = (a, b) -> a + b;

		// when
		int result = add.operate(10, 5);

		// then
		assertThat(result).isEqualTo(15);
	}

	interface MathOperation {
		int operate(int a, int b);
	}
}
