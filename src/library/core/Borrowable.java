package library.core;

import library.exceptions.AvailabilityException;

/**
 * @author istamatopoulou
 */

public interface Borrowable {
	public void borrowItem() throws AvailabilityException;

	public void returnItem() throws AvailabilityException;

	public boolean isAvailable();

	public int getId();
}