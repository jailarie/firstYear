import java.util.ArrayList;

public class Patron extends Library{

	int patronID;
	String patronName;
	ArrayList <Book> checkedOutBooks = new ArrayList <Book> ();
	int patronFineTotal = 0;
	
	public Patron(){}
	
	public Patron(int id, String name) {
		this.patronID = id;
		this.patronName = name;
		
	}
	
	public int getPatronID() {
		return this.patronID;
	}
	
	public String getPatronName() {
		return this.patronName;
	}
	
	public void printPatron() {
		System.out.println("ID number " + this.patronID + " belongs to " + this.patronName);
		System.out.println(this.patronName + " has checked out the following titles:");
		for(Book i : checkedOutBooks ) {
			System.out.println(i.getTitle());
		}
		System.out.println(this.patronName + " owes $" + patronFineTotal + " in overdue book fees.");
	}
	
	public void addBook(Book checkoutTitle) {
		checkedOutBooks.add(checkoutTitle);
		
	}
	
	public void removeBook(Book checkoutTitle) {
		checkedOutBooks.remove(checkoutTitle);
	}
	
	public int getFine() {
		return this.patronFineTotal;
	}


	public void payFine(int payment) {
		this.patronFineTotal += payment;
	}
	
	public void amendFine(int currentDate) {
		for(Book i : checkedOutBooks ) {
			if (currentDate > i.getDueDate() ) {
				int dateDifference = currentDate - i.getDueDate();
				patronFineTotal += (dateDifference * fineAmount);
			}
		}
	}
}	
