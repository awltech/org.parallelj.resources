package org.parallelj.sample.steps;

import org.parallelj.sample.csv.ContactLine;
import org.parallelj.sample.data.ContactManager;

public class Processor implements Runnable {

	private ContactLine contact;

	public void setContact(ContactLine contact) {
		this.contact = contact;
	}

	@Override
	public void run() {
		new ContactManager().create(this.contact.name, this.contact.surname,
				this.contact.mail, this.contact.birthdate);
	}

}
