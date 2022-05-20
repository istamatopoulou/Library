package library;

import library.core.Borrowable;
import library.exceptions.AvailabilityException;

/**
 * This class represents an actual copy of a book that is offered by the
 * library. Book Copies are Borrowable items.
 * 
 * @author istamatopoulou
 */

public class BookCopy implements Borrowable {
	private int id;
	private boolean available;
	private Book book;

	/**
	 * @param id
	 * @param book
	 */
	public BookCopy(int id, Book book) {
		this.id = id;
		available = true;
		this.book = book;
	}

	public BookCopy() {
		this.id = 0;
		available = true;
		book = null;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	public int getId() {
		return id;
	}

	@Override
	public void borrowItem() throws AvailabilityException {
		if (!available)
			throw new AvailabilityException("The book copy with id:\" + id + \" which is a copy of the book: \" + book.getTitle() + \" cannot be borrowed; it is already borrowed.");

		available = false;
	}

	@Override
	public void returnItem() throws AvailabilityException {
		if (available)
			throw new AvailabilityException("The book copy with id:" + id + " which is a copy of the book: " + book.getTitle() + " cannot be returned; it is already available.");

		available = true;
	}

	@Override
	public String toString() {
		return "BookCopy [id=" + id + ", available=" + available + ", book=" + book + "]";
	}

}
