package library.exceptions;
@SuppressWarnings("serial")
public class DoesNotExistException extends Exception {
	public DoesNotExistException() {
		super();
	}
	
	public DoesNotExistException(String msg) {
		super(msg);
	}
}
