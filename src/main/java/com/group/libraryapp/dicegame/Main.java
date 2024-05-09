package com.group.libraryapp.dicegame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.print("주사위를 몇번 굴릴까요? : ");
		Scanner scanner = new Scanner(System.in);
		int rolls = scanner.nextInt();
		scanner.close();

		System.out.println("==================================");
		DiceGame game = new DiceGame(rolls);
		game.playGame();
	}
}
