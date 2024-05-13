package com.group.libraryapp.service.fruit;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.libraryapp.dto.fruit.request.AddFruitRequest;
import com.group.libraryapp.dto.fruit.request.UpdateFruitRequest;
import com.group.libraryapp.dto.fruit.response.FruitSalesResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;

@Service
public class FruitService {

	private final FruitRepository fruitRepository;

	public FruitService(FruitRepository fruitRepository) {
		this.fruitRepository = fruitRepository;
	}

	public void addFruit(AddFruitRequest request) {
		fruitRepository.addFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
	}

	public void updateFruit(UpdateFruitRequest request) {
		if (fruitRepository.isFruitNotExist(request.getId())) {
			throw new IllegalArgumentException("과일을 찾을 수 없습니다");
		}

		fruitRepository.updateFruit(request.getId());
	}

	public FruitSalesResponse findByName(String name) {
		List<Long> salesAmounts = fruitRepository.findByName(name);

		Long salesAmount = salesAmounts.get(0);
		Long notSaleAmount = salesAmounts.get(1);

		return new FruitSalesResponse(salesAmount, notSaleAmount);
	}
}
