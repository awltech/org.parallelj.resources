package org.parallelj.sample.csv;

import java.util.Date;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

@CsvDataType(defaultPrefix = "")
public class ContactLine {

	@CsvField(pos = 1)
	public String name;

	@CsvField(pos = 2)
	public String surname;

	@CsvField(pos = 3)
	public String mail;

	@CsvField(pos = 4, format = "yyyyMMdd")
	public Date birthdate;

	@Override
	public String toString() {
		return name + " " + surname + " " + mail + " " + birthdate.toString();
	}

}