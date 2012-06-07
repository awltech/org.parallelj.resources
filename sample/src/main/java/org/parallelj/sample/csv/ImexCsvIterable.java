package org.parallelj.sample.csv;

import java.io.Reader;
import java.util.Iterator;

import org.jsefa.Deserializer;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;

public class ImexCsvIterable<E> implements Iterable<E> {
	
	private Deserializer deserializer;
	
	private Iterator<E> iterator;
	
	private Reader reader;

	@SuppressWarnings("rawtypes")
	public ImexCsvIterable(Reader reader, Class[] recordTypes)
			throws UnmarshallingException {
		this(reader, null, recordTypes);
	}

	@SuppressWarnings("rawtypes")
	public ImexCsvIterable(Reader reader, CsvConfiguration csvConfiguration,
			Class[] recordTypes) throws UnmarshallingException {
		super();
		if (reader == null) {
			throw new UnmarshallingException("Reader has not been set");
		}
		if (recordTypes == null || recordTypes.length == 0) {
			throw new UnmarshallingException("At least one type is required");
		}
		if (null == csvConfiguration) {
			csvConfiguration = new CsvConfiguration();
		}
		this.reader = reader;
		this.deserializer = CsvIOFactory.createFactory(csvConfiguration,
				recordTypes).createDeserializer();
	}

	public Iterator<E> iterator() {
		if (this.iterator == null) {
			this.iterator = new ImexCsvIterator<E>(this.reader,
					this.deserializer);
		}
		return this.iterator;
	}
}