package com.group.libraryapp.controller.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.calculator.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.CalculatorMultiplyRequest;

@RestController
public class CalculatorController {

	@GetMapping("/v1/add")
	public int addTwoNumbersV1(@RequestParam int number1, @RequestParam int number2) {
		return number1 + number2;
	}

	@GetMapping("/v2/add")
	public int addTwoNumbersV2(CalculatorAddRequest request) {
		return request.getNumber1() + request.getNumber2();
	}

	@PostMapping("/multiply")
	public int multiplyTwoNumbersV1(@RequestBody CalculatorMultiplyRequest request) {
		return request.getNumber1() * request.getNumber2();
	}
}
