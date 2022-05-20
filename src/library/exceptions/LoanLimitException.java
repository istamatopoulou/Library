package library.exceptions;

@SuppressWarnings("serial")
public class LoanLimitException extends Exception {
	public LoanLimitException() {
		super();
	}

	public LoanLimitException(String msg) {
		super(msg);
	}
}