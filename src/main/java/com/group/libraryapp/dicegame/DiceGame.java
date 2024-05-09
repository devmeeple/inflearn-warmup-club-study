package com.group.libraryapp.dicegame;

import java.util.stream.IntStream;

public class DiceGame {
	private static final int DICE_FACE = 6;

	private final int rolls;
	private final int[] rollCounts;

	public DiceGame(int rolls) {
		this.rolls = rolls;
		this.rollCounts = new int[DICE_FACE];
	}

	public void playGame() {
		countRolls();
		printResults();
	}

	private void countRolls() {
		IntStream.range(0, rolls)
			.map(i -> rollDice())
			.forEach(roll -> rollCounts[roll - 1]++);
	}

	private int rollDice() {
		return (int)(Math.random() * DICE_FACE) + 1;
	}

	private void printResults() {
		IntStream.range(0, rollCounts.length)
			.forEach(i -> System.out.printf("[%d] 은(는) [%d번] 나왔습니다.\n", i + 1, rollCounts[i]));
	}
}
