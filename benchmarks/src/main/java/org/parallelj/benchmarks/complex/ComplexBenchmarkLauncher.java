package org.parallelj.benchmarks.complex;

import java.util.concurrent.Executors;

import org.parallelj.Programs;

public class ComplexBenchmarkLauncher {

	public static void main(String[] args) {
		int argc = 0;
		String loopSize = argc < args.length ? args[argc++] : null;
		String arraySize = argc < args.length ? args[argc++] : null;
		ComplexBenchmark benchmark = new ComplexBenchmark();
		benchmark.setArraySize(Integer.parseInt(arraySize));
		benchmark.setLoopSize(Integer.parseInt(loopSize));
		Programs.as(benchmark).execute(Executors.newCachedThreadPool()).join();
	}

}
