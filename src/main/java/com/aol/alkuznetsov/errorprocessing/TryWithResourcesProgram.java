package com.aol.alkuznetsov.errorprocessing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesProgram {

	public static void main(String[] args) {

		try {
			writeFile(new BufferedWriter(new FileWriter("Easy TryWithResourses")), "This is easy since Java 9");
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public static void writeFile(BufferedWriter writer, String text) {
		// new feature - no need to declare a final variable writer
		try(writer) {
			writer.write(text);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

}
