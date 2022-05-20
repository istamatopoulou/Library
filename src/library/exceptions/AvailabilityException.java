package library.exceptions;

@SuppressWarnings("serial")

public class AvailabilityException extends Exception {
	public AvailabilityException() {
		super();
	}

	public AvailabilityException(String msg) {
		super(msg);
	}
}