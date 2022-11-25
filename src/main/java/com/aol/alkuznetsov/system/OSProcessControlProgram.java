package com.aol.alkuznetsov.system;

import java.time.Duration;
import java.util.Optional;

public class OSProcessControlProgram {

	public static void main(String[] args) {
		listProcessesInfo();
	}
	
	// just a snapshot of Ids
	public static void listProcesses() {
		ProcessHandle.allProcesses().forEach(System.out::println);
	}
	
	public static void listProcessesInfo() {
		ProcessHandle.allProcesses().forEach(h -> System.out.println(formattedProcessInfo(h)));
	}
	
	// more information on processes
	public static String formattedProcessInfo(ProcessHandle handle) {
		long pid = handle.pid();
		boolean isAlive = handle.isAlive();
		Optional<Duration> cpuDuration = handle.info().totalCpuDuration();
		Optional<String> handleName = handle.info().command();
		Optional<String> userName = handle.info().user();
		return pid + " alive: " + isAlive + " " + handleName + "CPU duration: " + cpuDuration + " user: " + userName;
	}


}
