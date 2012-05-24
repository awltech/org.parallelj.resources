package org.parallelj.benchmarks.simple.steps;

public class Process implements Runnable {

	private Integer input;
	private int loopSize;

	public void setInput(Integer aInput) {
		this.input = aInput;
	}

	public void setLoopSize(int aLoopSize) {
		this.loopSize = aLoopSize;
	}

	public Process() {
	}

	@Override
	public void run() {
		for (int i = 0; i < this.loopSize; i++) {
		}
		try {
			Thread.sleep(this.input);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
