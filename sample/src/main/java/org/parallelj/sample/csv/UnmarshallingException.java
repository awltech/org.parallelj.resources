package org.parallelj.sample.csv;

@SuppressWarnings("serial")
public class UnmarshallingException extends Exception {

	public UnmarshallingException() {
		super();
	}

	public UnmarshallingException(String msg) {
		super(msg);
	}

	public UnmarshallingException(Throwable t) {
		super(t);
	}

	public UnmarshallingException(String msg, Throwable t) {
		super(msg, t);
	}

}
