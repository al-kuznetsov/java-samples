package com.aol.alkuznetsov.userinput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AcceptUserInputRe {

	public static void main(String[] args) throws IOException {
		// create the read tool
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean validInput = false;
		String numberAsString = "";
		long wholeNumber;

		do {
			// prompt and read input
			System.out.println("Enter a whole number:");

			try {
				numberAsString = reader.readLine();
			} catch (IOException exc) {
				System.out.println("Error occured: " + exc.getMessage());
			}

			// parse input
			try {
				wholeNumber = Long.parseLong(numberAsString);
				System.out.println("You entered: " + wholeNumber);
				validInput = true;
			} catch (NumberFormatException exc) {
				System.out.println("Not a whole number!");
			}
		} while (!validInput);
		

		// close resources
		reader.close();

	}

}
