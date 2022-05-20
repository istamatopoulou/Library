package testing;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;
import org.junit.Test;
import library.exceptions.AvailabilityException;
import library.exceptions.LoanLimitException;
import library.Book;
import library.BookCopy;
import library.core.Member;

public class MemberTest {

	@Test
	public void borrows_ThrowsException_WhenMemberOverLimit() {
		Book b = new Book(100, "title", "author");
		BookCopy bc1 = new BookCopy(101, b);
		BookCopy bc2 = new BookCopy(102, b);
		BookCopy bc3 = new BookCopy(103, b);
		BookCopy bc4 = new BookCopy(104, b);
		BookCopy bc5 = new BookCopy(105, b);
		BookCopy bc6 = new BookCopy(106, b);
		BookCopy bc7 = new BookCopy(107, b);
		
		Member m = new Member(123, "ioanna");
		try {
			m.borrows(bc1);
			m.borrows(bc2);
			m.borrows(bc3);
			m.borrows(bc4);
			m.borrows(bc5);
			m.borrows(bc6);
			m.borrows(bc7);
			fail("Should throw an exception if member cannot borrow more");
		}
		catch(LoanLimitException e) {
			assertThat(e, isA(LoanLimitException.class));
		}
		catch(AvailabilityException e) {
			assertThat(e, isA(AvailabilityException.class));
		}
	}
}
