package org.parallelj.sample.csv;

import java.io.Reader;
import java.util.Iterator;

import org.jsefa.Deserializer;

public class ImexCsvIterator<E> implements Iterator<E> {
	@SuppressWarnings("rawtypes")
	public static Class[] pojosClasses = new Class[] { ContactLine.class };

	private Deserializer deserializer;

	ImexCsvIterator(Reader reader, Deserializer deserializer) {
		super();
		this.deserializer = deserializer;
		this.deserializer.open(reader);
	}

	public boolean hasNext() {
		return (deserializer.hasNext());
	}

	@SuppressWarnings("unchecked")
	public E next() {
		E e = (E) deserializer.next();
		if (e == null)
			this.deserializer.close(true);
		return e;
	}

	public void remove() {
		throw new UnsupportedOperationException("Remove not allowed.");
	}
}