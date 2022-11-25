package com.aol.alkuznetsov.streamapi;

import java.util.Arrays;
import java.util.List;

// You can use filters
public class StreamDemoProgram {

	public static void main(String[] args) {
		List<String> langs = Arrays.asList("Jython is great", "Groovy is awesome",
				"Scala is functional", "JRuby is productive", "Java is streamlined", "Kotlin is interesting");
		
		langs.stream().dropWhile(x -> !x.contains("Java")).forEach(System.out::println);
		
		System.out.println();
		
		langs.stream().takeWhile(s -> !s.contains("Java")).forEach(System.out::println);
		
		System.out.println();
		
		langs.stream().filter(s -> s.contains("Java")).forEach(System.out::println);
	
	}

}
