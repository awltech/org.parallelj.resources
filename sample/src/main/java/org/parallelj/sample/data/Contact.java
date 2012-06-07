package org.parallelj.sample.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "org.parallelj.sample.data.Contact.count", query = "select count (c) from Contact c") })
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String surname;

	private Date birthdate;

	private String mail;

	public Contact() {

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public Contact setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return this.surname;
	}

	public Contact setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public Contact setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	public String getMail() {
		return this.mail;
	}

	public Contact setMail(String mail) {
		this.mail = mail;
		return this;
	}
}
