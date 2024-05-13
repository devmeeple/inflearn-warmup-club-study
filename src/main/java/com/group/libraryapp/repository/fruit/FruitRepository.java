package com.group.libraryapp.repository.fruit;

import java.time.LocalDate;
import java.util.List;

public interface FruitRepository {

	void addFruit(String name, LocalDate warehousingDate, long price);

	List<Long> findByName(String name);

	void updateFruit(long id);

	boolean isFruitNotExist(long id);
}
