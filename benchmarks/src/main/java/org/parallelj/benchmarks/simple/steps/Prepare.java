package org.parallelj.benchmarks.simple.steps;

import org.apache.log4j.Logger;

public class Prepare implements Runnable {

	private long start;
	private Logger logger;

	public long getStart() {
		return this.start;
	}

	public Logger getLogger() {
		return this.logger;
	}

	public Prepare() {
	}

	@Override
	public void run() {
		this.logger = Logger.getLogger("org.parallelj.benchmarks.simple");
		this.start = System.currentTimeMillis();
	}

}
