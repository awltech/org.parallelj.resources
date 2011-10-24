package org.parallelj.example;

import java.util.concurrent.Executors;

import org.parallelj.Programs;

public class DemoRunner {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("start");
		org.parallelj.Process<Demo> instance = Programs.as(new Demo());
		instance.execute(Executors.newCachedThreadPool());
		instance.join();
		System.out.println("end: " + (System.currentTimeMillis() - start)
				+ "ms");
		System.exit(0);
	}

}
