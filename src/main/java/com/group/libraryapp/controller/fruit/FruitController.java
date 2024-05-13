package com.group.libraryapp.controller.fruit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.fruit.request.AddFruitRequest;
import com.group.libraryapp.dto.fruit.request.UpdateFruitRequest;
import com.group.libraryapp.dto.fruit.response.FruitSalesResponse;
import com.group.libraryapp.service.fruit.FruitService;

@RequestMapping("/api/v1/fruit")
@RestController
public class FruitController {

	private final FruitService fruitService;

	public FruitController(FruitService fruitService) {
		this.fruitService = fruitService;
	}

	// TODO: 2024.05.12 http POST :8080/api/v1/fruit name=사과 warehousingDate=2024-01-02 price=2000
	@PostMapping
	public void addFruit(@RequestBody AddFruitRequest request) {
		fruitService.addFruit(request);
	}

	// TODO: 2024.05.12 http PUT :8080/api/v1/fruit id=10
	@PutMapping
	public void updateFruit(@RequestBody UpdateFruitRequest request) {
		fruitService.updateFruit(request);
	}

	// TODO: 2024.05.12 http GET :8080/api/v1/fruit/stat name==사과
	@GetMapping("/stat")
	public FruitSalesResponse findByName(@RequestParam String name) {
		return fruitService.findByName(name);
	}
}
