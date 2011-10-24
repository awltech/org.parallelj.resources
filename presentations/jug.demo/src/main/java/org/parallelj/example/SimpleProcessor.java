package org.parallelj.example;

import java.util.Collection;

public class SimpleProcessor implements Runnable {

	private Collection<String> data;

	public SimpleProcessor(Collection<String> d) {
		this.data = d;
	}

	@Override
	public void run() {
		for (String s : this.data) {
			System.out.println(s);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
