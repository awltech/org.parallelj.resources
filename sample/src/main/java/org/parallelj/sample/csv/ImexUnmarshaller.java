package org.parallelj.sample.csv;

import java.io.Reader;
import java.util.ArrayList;

import org.jsefa.csv.CsvDeserializer;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;

public class ImexUnmarshaller {

	CsvConfiguration csvConfiguration = null;

	public ImexUnmarshaller() throws UnmarshallingException {
		super();
		this.csvConfiguration = configure();
	}

	/**
	 * Stream unmarshalling using an Iterable over all instances of all root
	 * types specified by <code>recordTypes</code>. Useful to browse file record
	 * by record; inside Control Flow Perspective, for instance.
	 * 
	 * @param reader
	 *            the underlying Reader
	 * @param recordTypes
	 *            the root types mapping each record types to be selected
	 * @return an Iterable to be used inside Control Flow Perspective to browse
	 *         file
	 */
	@SuppressWarnings("rawtypes")
	public <T> Iterable<T> streamUnmarshal(Reader reader, Class[] recordTypes)
			throws UnmarshallingException {
		return new ImexCsvIterable<T>(reader, csvConfiguration, recordTypes);
	}

	/**
	 * Convenient method to configure CSV file processing. This place a user has
	 * ability to set some particular process options amongst these permitted:
	 * ex:
	 * <code>csvConfiguration.setLineFilter(new HeaderAndFooterFilter(1, false, false));</code>
	 * 
	 * @return a specific configuration for CSV file processing
	 */
	protected CsvConfiguration configure() {
		CsvConfiguration csvConfiguration = new CsvConfiguration();
		return csvConfiguration;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> void deserialize(Reader reader,
			CsvConfiguration csvConfiguration, Class[] recordTypes,
			ArrayList<T> types) {
		CsvDeserializer deserializer = CsvIOFactory.createFactory(
				csvConfiguration, recordTypes).createDeserializer();
		deserializer.open(reader);
		while (deserializer.hasNext()) {
			T next = (T) deserializer.next();
			types.add(next);
		}
		deserializer.close(true);
	}

	/**
	 * @return Stream unmarshalling using an Iterable over all instances of all
	 *         Contact. Useful to browse file record by record; inside Control
	 *         Flow Perspective, for instance.
	 * @param reader
	 *            the underlying Reader
	 * @param recordTypes
	 *            the root types mapping each record types to be selected an
	 *            Iterable to be used inside Control Flow Perspective to browse
	 *            file.
	 */
	public Iterable<ContactLine> streamUnmarshalContact(Reader reader)
			throws UnmarshallingException {
		return new ImexCsvIterable<ContactLine>(reader, csvConfiguration,
				new Class[] { ContactLine.class });
	}

	/**
	 * @return Oneshot unmarshalling for all the root types.
	 * @param reader
	 *            data the underlying Reader an ArrayList containing all the
	 *            instances of all root types from the whole file
	 */
	public ArrayList<Object> unmarshal(Reader reader)
			throws UnmarshallingException {
		ArrayList<Object> types = new ArrayList<Object>();
		deserialize(reader, csvConfiguration, ImexCsvIterator.pojosClasses,
				types);
		return types;
	}

	/**
	 * @return Stream unmarshalling using an Iterable over all instances of all
	 *         root types. Useful to browse file record by record; inside
	 *         Control Flow Perspective, for instance.
	 * @param reader
	 *            the underlying Reader
	 * @param recordTypes
	 *            the root types mapping each record types to be selected an
	 *            Iterable to be used inside Control Flow Perspective to browse
	 *            file.
	 */
	@SuppressWarnings("rawtypes")
	public Iterable streamUnmarshal(Reader reader)
			throws UnmarshallingException {
		return streamUnmarshal(reader, ImexCsvIterator.pojosClasses);
	}
}
