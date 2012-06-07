package org.parallelj.sample.steps;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.parallelj.sample.csv.ContactLine;
import org.parallelj.sample.csv.ContactListReader;

public class Initialize implements Runnable {

	private Collection<ContactLine> resolvedContacts;

	public Collection<ContactLine> getResolvedContacts() {
		return this.resolvedContacts;
	}

	private Logger logger;

	public Logger getLogger() {
		return this.logger;
	}

	@Override
	public void run() {
		this.logger = Logger.getLogger("org.parallelj.sample");
		this.resolvedContacts = ContactListReader.getContacts("/big.csv");
	}

}
