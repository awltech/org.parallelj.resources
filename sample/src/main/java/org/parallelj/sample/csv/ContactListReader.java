package org.parallelj.sample.csv;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ContactListReader {

	public static Iterator<ContactLine> getReader(String resourceName) {
		InputStream stream = ContactListReader.class
				.getResourceAsStream(resourceName);
		InputStreamReader reader = new InputStreamReader(stream);
		try {
			Iterable<ContactLine> iterable = new ImexUnmarshaller()
					.streamUnmarshalContact(reader);
			Iterator<ContactLine> iterator = iterable.iterator();
			return iterator;
		} catch (UnmarshallingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Collection<ContactLine> getContacts(String resourceName) {
		InputStream stream = ContactListReader.class
				.getResourceAsStream(resourceName);
		InputStreamReader reader = new InputStreamReader(stream);
		List<ContactLine> result = new ArrayList<ContactLine>();
		try {
			Iterable<ContactLine> iterable = new ImexUnmarshaller()
					.streamUnmarshalContact(reader);
			Iterator<ContactLine> iterator = iterable.iterator();
			while (iterator.hasNext())
				result.add(iterator.next());
			return result;
		} catch (UnmarshallingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
