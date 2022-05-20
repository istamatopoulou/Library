package library.core;

import java.util.Map;
import library.Book;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class LibraryMaps {

	private Map<Integer, Member> members;
	private Map<Integer, Title> titles;
	private Map<Integer, Borrowable> borrowables;

	public LibraryMaps() {
		members = new HashMap<Integer, Member>();
		titles = new HashMap<Integer, Title>();
		borrowables = new HashMap<Integer, Borrowable>();
	}

	public void addMember(int id, String name) {
		if (!members.containsKey(id)) {
			members.put(id, new Member(id, name));
		}
	}

	public void addTitle(Title title) {
		int id = title.getId();
		if (!titles.containsKey(id))
			titles.put(id, title);
		//else THROW EXCEPTION
	}

	public void addBorrowable(Borrowable b) {
		int id = b.getId();
		if (!borrowables.containsKey(id))
			borrowables.put(id, b);
		//else THROW EXCEPTION
	}

	public void displayAllMembers() {
		System.out.println("\nLIBRARY'S MEMBERS:\n");
		Collection<Member> allMembers = members.values();
		for (Member m : allMembers) {
			System.out.println(m + "\n");
		}
		System.out.println("=============================\n");
	}

	public void displayAllBorrowables() {
		System.out.println("LIBRARY'S BORROWABLE ITEMS:\n");
		Collection<Borrowable> allBorrowables = borrowables.values();
		for (Borrowable item : allBorrowables) {
			System.out.println(item);
		}
		System.out.println("=============================\n");
	}

	public void displayBorrowedItems() {
		System.out.println("LIBRARY'S ITEMS CURRENTLY ON LOAN:\n");
		Collection<Borrowable> allBorrowables = borrowables.values();
		for (Borrowable item : allBorrowables) {
			if (!item.isAvailable())
				System.out.println(item);
		}
		System.out.println("=============================\n");
	}

	public Member findMemberByName(String n) {
		Collection<Member> mem = members.values();
		for (Member m : mem) {
			if (m.getName().equals(n))
				return m;
		}
		return null;
	}

	public Borrowable findBorrowableByID(int id) {
		if (borrowables.containsKey(id))
			return borrowables.get(id);
		else
			return null;
	}

	public Title findTitleByID(int id) {
		if (titles.containsKey(id))
			return titles.get(id);
		else
			return null;
	}

	public Member findMemberByID(int id) {
		if (members.containsKey(id))
			return members.get(id);
		else
			return null;
	}

	public String[] getAllBooksInfo() {
		List<String> allBookData = new ArrayList<String>();
		Collection<Title> allTitles = titles.values();
		for (Title t : allTitles) {
			if (t instanceof Book) {
				allBookData.add("\"" + t.getTitle() + "\", " + ((Book) t).getAuthor());
			}
		}
		return allBookData.toArray(new String[0]);
	}
}