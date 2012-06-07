package org.parallelj.sample.steps;

import org.parallelj.sample.data.ContactManager;

public class Validate implements Runnable {

	private boolean ok;

	public boolean isOk() {
		return this.ok;
	}

	@Override
	public void run() {
		this.ok = new ContactManager().count() == 80000;
	}

}
