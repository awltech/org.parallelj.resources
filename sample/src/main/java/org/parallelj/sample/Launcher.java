package org.parallelj.sample;

import java.util.concurrent.Executors;

import org.parallelj.Programs;

public class Launcher {

	public static void main(String[] args) {
		Programs.as(new ImportContacts())
				.execute(Executors.newFixedThreadPool(25)).join();
	}

}
