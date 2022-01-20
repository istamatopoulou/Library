

/**
 * @author istamatopoulou
 */


public interface Borrowable {
	public void isBeingBorrowed(); //throws AvailabilityException;

	public void isBeingReturned(); //throws AvailabilityException;

	public boolean isAvailable();

	public int getId();
}