package library.core;
import java.util.List;
import library.exceptions.AvailabilityException;
import library.exceptions.CannotBeReturnedByMemberException;
import library.exceptions.LoanLimitException;
import java.util.ArrayList;

public class Member {
	private int id;
	private String name;
	final static int MAX_ON_LOAN = 6;
	//THIS LIST CONTAINS ALL THE ITEMS THAT THE MEMBER NOW HAS ON LOAN:
	private List<Borrowable> onLoan;
	
	public Member(int id, String name) {
		this.id = id;
		this.name = name;
		onLoan = new ArrayList<Borrowable>();
	}

	public void borrows(Borrowable b) throws LoanLimitException, AvailabilityException{
		//if the member has MAX on loan items
		if (!canBorrow())
			throw new LoanLimitException("cannot borrow more");
			
		
		// does anything happen to the parameter? (borrowable b)?
		b.borrowItem();	
			
		//b must be added to the list of the member (that contains the borrowed items
		onLoan.add(b);
	}

	public void returns(Borrowable b)throws CannotBeReturnedByMemberException, AvailabilityException{
		if(!onLoan.contains(b)) 
			throw new CannotBeReturnedByMemberException("Item " + b + " does not appear to be on loan by this member with ID: " + id);
		
		b.returnItem();
		onLoan.remove(b);
	}

	public String toString() {
		String bs;
		if (onLoan.size() > 0) {
			bs = "\nCurrently has on loan the following " + onLoan.size() + " items:";
			for (Borrowable b : onLoan) {
				bs += "\n-" + b;
			}
		}
		else
			bs = "\nCurrently has nothing on loan";

		return  "Member ID: " + id + "\nMember Name: " + name + bs;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private boolean canBorrow(){
		return onLoan.size() < MAX_ON_LOAN;
	}
}