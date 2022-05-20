package library;

import library.core.Title;

/**
 * This class represents a book that is offered by the library, (i.e. the
 * existence of a book, not an actual copy). The class extends the Title class
 * (a book is a kind of title offered by the library)
 * 
 * @see Title
 * @author istamatopoulou
 */

public class Book extends Title {
	private String author;
	//private ArrayList<BookCopy> allCopies;

	/**
	 * @param id
	 * @param title
	 * @param author
	 */
	public Book(int id, String title, String author) {
		super(id, title);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", " + super.toString() + "]";
	}
}