package com.group.libraryapp.dto.fruit.response;

public class FruitSalesResponse {
	private final long salesAmount;
	private final long notSalesAmount;

	public FruitSalesResponse(long salesAmount, long notSalesAmount) {
		this.salesAmount = salesAmount;
		this.notSalesAmount = notSalesAmount;
	}

	public long getSalesAmount() {
		return salesAmount;
	}

	public long getNotSalesAmount() {
		return notSalesAmount;
	}
}
