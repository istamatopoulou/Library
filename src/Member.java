import java.util.List;
import java.util.ArrayList;

public class Member {
	private int id;
	private String name;
	private final int MAX_ON_LOAN = 6;



	private List<Borrowable> onLoan;
	//THIS LIST CONTAINS ALL THE ITEMS THAT THE MEMBER NOW HAS ON LOAN



	public Member(int id, String name) {
		this.id = id;
		this.name = name;
		//onLoan = new ArrayList<Borrowable>();
	}

	public void borrows(Borrowable b){
		//if the member does not already have MAX on loan
		if (canBorrow()) {
			//b must be added to the list of the member (that contains the borrowed items
			onLoan.add(b);
			// does anything happen to the parameter? (borrowable b)?
			b.isBeingBorrowed();
		}
	}

	public void returns(Borrowable b){
		if(onLoan.contains(b)) {
			onLoan.remove(b);
			b.isBeingReturned();
		}
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

	public boolean canBorrow(){
		return onLoan.size() < MAX_ON_LOAN;
	}
}