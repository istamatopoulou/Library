package library.exceptions;

@SuppressWarnings("serial")
public class AlreadyExistsException extends Exception {
	public AlreadyExistsException() {
		super();
	}

	public AlreadyExistsException(String msg) {
		super(msg);
	}
}