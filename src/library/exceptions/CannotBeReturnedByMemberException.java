package library.exceptions;

@SuppressWarnings("serial")
public class CannotBeReturnedByMemberException extends Exception {
	public CannotBeReturnedByMemberException() {
		super();
	}

	public CannotBeReturnedByMemberException(String msg) {
		super(msg);
	}
}