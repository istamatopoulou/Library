package library.core;

import java.util.Collection;
import java.util.List;
import library.exceptions.*;
//import library.*;
import java.util.ArrayList;

public class LibraryLists {

	private List<Member> members;
	private List<Title> titles;
	private List<Borrowable> borrowables;

	public LibraryLists() {
		members = new ArrayList<Member>();
		titles = new ArrayList<Title>();
		borrowables = new ArrayList<Borrowable>();
	}

	public void addMember(int id, String name) throws AlreadyExistsException {
		members.add(new Member(id, name));
	}

	public void addTitle(Title title) {
		if (!titles.contains(title))
			titles.add(title);
	}

	public void addBorrowable(Borrowable b) {
		if (!borrowables.contains(b))
			borrowables.add(b);
	}

	public void displayAllMembers() {
		System.out.println("\nLIBRARY'S MEMBERS:\n");
		
		for (Member m : members) {
			System.out.println(m + "\n");
		}
		System.out.println("=============================\n");
	}

	public void displayAllBorrowables() {
		System.out.println("LIBRARY'S BORROWABLE ITEMS:\n");

		for (Borrowable item : borrowables) {
			System.out.println(item);
		}
		System.out.println("=============================\n");
	}

	public void displayBorrowedItems() {
		System.out.println("LIBRARY'S ITEMS CURRENTLY ON LOAN:\n");

		for (Borrowable item : borrowables) {
			if (!item.isAvailable())
				System.out.println(item);
		}
		System.out.println("=============================\n");
	}

	public Member findMemberByName(String n) {

		for (Member m : members) {
			if (m.getName().equals(n))
				return m;
		}
		return null;
	}

	public Borrowable findBorrowableByID(int id) throws DoesNotExistException {
		for (Borrowable b : borrowables) {
			if (b.getId() == id)
				return b;
		}
		return null;
	}

	public Title findTitleByID(int id) throws DoesNotExistException {
		for (Title t : titles) {
			if (t.getId() == id)
				return t;
		}
		return null;
	}

	public Member findMemberByID(int id) throws DoesNotExistException {
		for (Member m : members) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}
}