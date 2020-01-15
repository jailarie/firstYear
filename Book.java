
public class Book extends Library{

	int isbnNumber;
	String title;
	String author;
	String location = "On Shelf";
	String checkedOutBy;
	String requestedBy;
	int dateCheckedOut;
	int dueDate;
	static int check_out_length = 7;
	
	public Book(){
		
		
	}
	
	public Book(int id, String title, String author){
		this.isbnNumber = id;
		this.title = title;
		this.author = author;
		this.checkedOutBy = null;
		this.requestedBy = null;
		
	}
	
	public int getDueDate() {
		return this.dueDate;
	}
	
	public int getBookISBN() {
		return this.isbnNumber;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getRequestedBy() {
		return this.requestedBy;
	}
	
	public void printBook() {
		System.out.println("ISBN: " + this.isbnNumber);
		System.out.println(this.title);
		System.out.println("By " + this.author);
		System.out.println("Location: " + this.location);
		System.out.println("Checked out by: " + this.checkedOutBy);
		System.out.println("Due back on: Day " + dueDate);
		System.out.println("Requested by: " + this.requestedBy);
	}

	public String getLocation() {
		return this.location;
		//
	}
	
	public void checkOutBook(String patronName, int bookISBN) {
		this.checkedOutBy  = patronName;
		this.requestedBy = null;
		this.location = "Checked Out";
		this.dateCheckedOut = currentDate;
		this.dueDate = dateCheckedOut + check_out_length;
		System.out.println(this.title + " has been checked out by " + this.checkedOutBy + " for " + check_out_length + " days and is due back on day " + dueDate);	
	}
	
	public void returnBook(String patronName, int bookISBN) {
		this.checkedOutBy  = null;
		this.location = "On Shelf";
		this.dateCheckedOut = 0;
		this.dueDate = 0;
		System.out.println(this.title + " has been returned.");	
	}
	
	public void requestBook(String patronName) {
		this.location = "On Hold Shelf";
		this.requestedBy = patronName;
	}
	
}



