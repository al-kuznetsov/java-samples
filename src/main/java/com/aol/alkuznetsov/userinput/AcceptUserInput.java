package com.aol.alkuznetsov.userinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptUserInput {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String numberAsString = "";
		long numberAsLong;

		boolean numberIsValid = false;

		do {
			System.out.println("Please, enter a number: ");

			try {
				numberAsString = br.readLine();
				System.out.println("Your input " + numberAsString);
			} catch (IOException e) {
				System.out.println("IO error occurred " + e.getMessage());
			}

			try {
				numberAsLong = Long.parseLong(numberAsString);
				System.out.println("You've entered a valid number " + numberAsLong);
				numberIsValid = true;
			} catch (NumberFormatException exc) {
				System.out.println("You must enter a valid number. Try again.");
			}

		} while (!numberIsValid);

		br.close();
	}

}
