package org.parallelj.benchmarks.simple.steps;

import java.util.ArrayList;
import java.util.Collection;

public class Initialize implements Runnable {

	private int arraySize;
	private Collection<Integer> data;

	public void setArraySize(int aArraySize) {
		this.arraySize = aArraySize;
	}

	public Collection<Integer> getData() {
		return this.data;
	}

	public Initialize() {
		this.data = new ArrayList<Integer>();
	}

	@Override
	public void run() {
		for (int i = 0; i < this.arraySize; i++)
			this.data.add(50);
	}

}
