package org.parallelj.sample.data;

import java.util.Date;

import org.parallelj.sample.data.PersistenceHelper.TransactionManager;

public class ContactManager {

	public void create(String name, String surname, String mail, Date birthdate) {
		this.create(new Contact().setName(name).setSurname(surname)
				.setMail(mail).setBirthdate(birthdate));
	}

	protected void create(Contact c) {
		TransactionManager t = PersistenceHelper.getTransactionManager().init()
				.begin();
		t.getEntityManager().persist(c);
		t.commit().close();
	}

	public Long count() {
		TransactionManager t = PersistenceHelper.getTransactionManager().init();
		Long result = (Long) t.getEntityManager()
				.createNamedQuery("org.parallelj.sample.data.Contact.count")
				.getSingleResult();
		t.close();
		return result;
	}

}
