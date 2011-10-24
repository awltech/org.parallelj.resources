package org.parallelj.example;

public class ParallelProcessor implements Runnable {

	private String msg;

	public ParallelProcessor(String s) {
		this.msg = s;
	}

	@Override
	public void run() {
		System.out.println(msg);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
