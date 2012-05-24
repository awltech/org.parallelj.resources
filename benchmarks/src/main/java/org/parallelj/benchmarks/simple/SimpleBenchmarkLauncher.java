package org.parallelj.benchmarks.simple;

import java.util.concurrent.Executors;

import org.parallelj.Programs;

public class SimpleBenchmarkLauncher {

	public static void main(String[] args) {
		int argc = 0;
		String loopSize = argc < args.length ? args[argc++] : null;
		String arraySize = argc < args.length ? args[argc++] : null;
		SimpleBenchmark benchmark = new SimpleBenchmark();
		benchmark.setArraySize(Integer.parseInt(arraySize));
		benchmark.setLoopSize(Integer.parseInt(loopSize));
		Programs.as(benchmark).execute(Executors.newCachedThreadPool()).join();
	}

}
