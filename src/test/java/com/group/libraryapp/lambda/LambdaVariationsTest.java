package com.group.libraryapp.lambda;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("람다의 다양한 형식")
public class LambdaVariationsTest {

	@Test
	public void testSimpleLambda() {
		// given
		StringOperation operation = s -> s.toUpperCase();

		// when
		String result = operation.operate("java");

		// then
		assertThat(result).isEqualTo("JAVA");
	}

	@Test
	public void testMultiStatementLambda() {
		// given
		StringOperation operation = s -> {
			String result = s.toUpperCase();
			return result + "!";
		};

		// when
		String result = operation.operate("spring");

		// then
		assertThat(result).isEqualTo("SPRING!");
	}

	@Test
	public void testLambdaWithMultipleParameters() {
		// given
		MathOperation operation = (a, b) -> a * b;

		// when
		int result = operation.operate(10, 5);

		// then
		assertThat(result).isEqualTo(50);
	}

	@Test
	public void testLambdaWithNoParameters() {
		// given
		Greeting greeting = () -> "Hello, World!";

		// when
		String result = greeting.greet();

		// then
		assertThat(result).isEqualTo("Hello, World!");
	}

	interface StringOperation {
		String operate(String s);
	}

	interface MathOperation {
		int operate(int a, int b);
	}

	interface Greeting {
		String greet();
	}
}
