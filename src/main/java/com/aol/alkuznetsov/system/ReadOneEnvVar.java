package com.aol.alkuznetsov.system;

public class ReadOneEnvVar {

	public static void main(String[] args) {
		
		String envVarName = "Java_Home";
		
		System.out.println(envVarName + " = " + System.getenv(envVarName));

	}

}
