package testing;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import library.exceptions.*;
import library.Book;
import library.BookCopy;
import org.junit.Test;

public class BookCopyTest {

	@Test
	public void isAvailable_True_WhenNew() {
		Book b = new Book(100, "title", "author");
		BookCopy bc = new BookCopy(102, b);
		assertTrue(bc.isAvailable());
	}

	@Test
	public void isAvailable_False_WhenBorrowed() {
		Book b = new Book(100, "title", "author");
		BookCopy bc = new BookCopy(102, b);
		try {
			bc.borrowItem();
		}
		catch (Exception e) {
		}
		assertFalse(bc.isAvailable());
	}

	@Test
	public void borrowItem_ThrowsException_WhenItemIsBorrowed() {
		Book b = new Book(100, "title", "author");
		BookCopy bc = new BookCopy(102, b);

		try {
			bc.borrowItem();
			bc.borrowItem();
			fail("Should throw an exception if book copy is not available");
		}
		catch (AvailabilityException e) {
			assertThat(e, isA(AvailabilityException.class));
		}
	}

}
