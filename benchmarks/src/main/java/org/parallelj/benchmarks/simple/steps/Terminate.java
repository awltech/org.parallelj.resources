package org.parallelj.benchmarks.simple.steps;

import org.apache.log4j.Logger;

public class Terminate implements Runnable {

	private Logger logger;
	private long start;

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public Terminate() {
	}

	@Override
	public void run() {
		long end = System.currentTimeMillis();
		logger.info("Total time: " + (end - start) + " ms");
	}

}
