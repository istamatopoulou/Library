

/**
 * This class represents an actual copy of a book that is offered by the library.
 * Book Copies are Borrowable items.
 * @author istamatopoulou
 */

public class BookCopy implements Borrowable{
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
	public void isBeingBorrowed() {
		if (available)
			available = false;
	}

	@Override
	public void isBeingReturned(){
		if(!available)
			available = true;
	}

	@Override
	public String toString() {
		return "BookCopy [id=" + id + ", available=" + available + ", book=" + book + "]";
	}




}
