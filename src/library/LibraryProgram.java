package library;


import java.util.Scanner;
import library.core.Borrowable;
import library.core.LibraryLists;
import library.core.LibraryMaps;
import library.core.Member;
import library.exceptions.AvailabilityException;
import library.exceptions.CannotBeReturnedByMemberException;
import library.exceptions.LoanLimitException;


public class LibraryProgram {

	static LibraryLists lib = new LibraryLists();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		lib.addTitle(new Book(1, "1984", "George Orwell"));
		lib.addTitle(new Journal(2, "Journal of AI", "Springer"));
		lib.addTitle(new Book(3, "East of Eden", "John Steinbeck"));

		lib.addBorrowable(new BookCopy(1, (Book) (lib.findTitleByID(1))));
		lib.addBorrowable(new BookCopy(2, (Book) (lib.findTitleByID(1))));
		lib.addBorrowable(new BookCopy(3, (Book) (lib.findTitleByID(3))));

		lib.displayAllBorrowables();

		addMember();
		addMember();

		newLoan();
		newLoan();

		lib.displayAllMembers();
		lib.displayBorrowedItems();

		returnLoan();

		lib.displayAllMembers();
		lib.displayBorrowedItems();
	}

	public static void addMember() {
		System.out.println("\n\nFUNCTIONALITY: ADD NEW MEMBER");

		System.out.println("Please, provide new member’s name: ");
		String memberName = scan.nextLine();

		System.out.println("Please, provide new member’s ID: ");
		int memberID = scan.nextInt();
		scan.nextLine();

		lib.addMember(memberID, memberName);

	}

	public static void newLoan() {
		System.out.println("\n\nFUNCTIONALITY: NEW LOAN");

		System.out.println("Please, provide member’s ID: ");
		int memberID = scan.nextInt();
		scan.nextLine();

		System.out.println("Please, provide borrowable item’s ID: ");
		int borID = scan.nextInt();
		scan.nextLine();

		Member m;
		Borrowable b;

		m = lib.findMemberByID(memberID);
		b = lib.findBorrowableByID(borID);
		try {
			m.borrows(b);
		}
		catch(AvailabilityException | LoanLimitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void returnLoan() {
		System.out.println("\n\nFUNCTIONALITY: RETURN LOAN");

		System.out.println("Please, provide member’s ID: ");
		int memberID = scan.nextInt();
		scan.nextLine();

		System.out.println("Please, provide borrowable item’s ID: ");
		int borID = scan.nextInt();
		scan.nextLine();

		Member m;
		Borrowable b;

		m = lib.findMemberByID(memberID);
		b = lib.findBorrowableByID(borID);
		try {
			m.returns(b);
		}
		catch (CannotBeReturnedByMemberException | AvailabilityException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}