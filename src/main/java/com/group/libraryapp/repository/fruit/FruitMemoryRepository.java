package com.group.libraryapp.repository.fruit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FruitMemoryRepository implements FruitRepository {

	@Override
	public void addFruit(String name, LocalDate warehousingDate, long price) {

	}

	@Override
	public List<Long> findByName(String name) {
		return List.of();
	}

	@Override
	public void updateFruit(long id) {

	}

	@Override
	public boolean isFruitNotExist(long id) {
		return false;
	}
}
