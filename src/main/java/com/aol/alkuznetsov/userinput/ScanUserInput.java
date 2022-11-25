package com.aol.alkuznetsov.userinput;

import java.util.Scanner;

public class ScanUserInput {

	public static void main(String[] args) {

		// get the input tool
		Scanner scanner = new Scanner(System.in);

		// read scanner input and process InputMismatchException
		boolean validNumberInput = false;
		long longNumber;

		// !!! Баг - уходит в бесконечный цикл при неправильном вводе!!! 
		do {
			System.out.println("Please, enter a whole number: ");

			if (scanner.hasNextLong()) {
				longNumber = scanner.nextLong();
				validNumberInput = true;
				System.out.println("You entered the number: " + longNumber);
			} else {
				System.out.println("Not a valid whole number!");
			}
		} while (!validNumberInput);

		// close resources
		scanner.close();
	}
}
