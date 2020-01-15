
import java.util.Scanner;
import java.util.ArrayList;

public class Library {

	ArrayList <Patron> patronList = new ArrayList<Patron>();
	ArrayList <Book> bookList = new ArrayList <Book> ();
	
	
	double fineAmount = 2;
	int patronID = 1000;
	int bookID = 0;
	int currentDate;
	
	
	public Library() {
		this.currentDate = 0;
	}
	
	public static void main(String[] args) {
		
		Library myLibrary = new Library();
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 10)
		{
			System.out.println("1: Check out book");
			System.out.println("2: Return book");
			System.out.println("3: Request book");
			System.out.println("4: Pay fine");
			System.out.println("5: Increment current date");
			System.out.println("6: View patron info");
			System.out.println("7: View book info");
			System.out.println("8: Add book");
			System.out.println("9: Add member");
			System.out.println("10: Quit");

			choice = input.nextInt();
			myLibrary.menuChoice(choice);
			
	}
		System.out.println("Thank you for visiting the library!");
}
	
public void menuChoice(int choice){

		Scanner menuInput = new Scanner(System.in);
		switch(choice) {
		
		case 1:
			//checkout
			checkOutBook();
			break;
			
		case 2:
			//return book
				//update the Book's location (and possibly requestedBy) 
				//depending on whether another Patron has requested it;
			returnBook();
			break;
			
		case 3:
			//request book
			requestBook();
			break;
			
		case 4:
			//pay fine
			payFine();
			break;
			
		case 5:
			//increment date
			incrementCurrentDate();
			incrementFines();
			break;
			
		case 6:
			//view patron info
			viewPatron();
			break;
			
		case 7:
			//view book info
			viewBook();
			
			break;
			
		case 8:
			//addBook
			addBook();
			break;
			
		case 9:
			//addMember
			addPatron();
			break;
		}
}

	public int addBook() {
		bookID++; //increments ID so each new book has a unique number
		Scanner book = new Scanner(System.in);

		System.out.println("Book title: ");
		String title = book.nextLine();
		System.out.println("Book author: ");
		String author = book.nextLine();
		
		bookList.add(new Book(bookID, title, author));
		System.out.println("You have added " + title + " by " + author + " to the library with ID number " + bookID + ".");
		return bookID;
	}
	
	public int addPatron() {
		patronID ++; //increments ID so each new patron has a unique number
		Scanner patron = new Scanner(System.in);
		
		
		System.out.println("Please enter the patron's name: ");
		String name = patron.next();
		
		patronList.add(new Patron(patronID, name)); 
		System.out.println(name + " is now a patron of the library with ID number " + patronID + ".");
		System.out.println("");
		
		return patronID;
	}
	
	
	public int incrementCurrentDate(){
		Scanner dateScanner = new Scanner(System.in);
		System.out.println("How many days would you like to increase the current date by?");
		int increase = dateScanner.nextInt();
		currentDate += increase;

		System.out.println("Current date is: " + currentDate);
		System.out.println("");
		return currentDate;

	}
	
	public void incrementFines() {
		for(Patron i : patronList ) {
			if(i.checkedOutBooks.isEmpty() == true) {
			}
			else {
				for(Book j: i.checkedOutBooks) {
					i.amendFine(currentDate);
				}
			}
		}
	}
	
	public void checkOutBook() {
		boolean patronInList = false;
		boolean bookInList = false;

		Scanner checkOutScanner = new Scanner(System.in);
		
		if (patronList.isEmpty() == true) {
			System.out.println("No patrons library's database.");
		}
		
		else {
			System.out.println("Please enter your patron ID: ");
			int patronCheckoutID = checkOutScanner.nextInt();
			
		
		for(Patron i : patronList ) {
			
			if (i.getPatronID() == patronCheckoutID) {
				patronInList = true;
				
				if (bookList.isEmpty() == true) {
					System.out.println("No books in library's database.");
					break;
				}
					
				else {
					System.out.print("Please enter the ID of the book you would like: ");
					int checkoutISBN = checkOutScanner.nextInt();
				for(Book j : bookList ) {
					if (j.getBookISBN() == checkoutISBN) {
						bookInList = true;
						j.getLocation();
						
						if(j.getLocation() == "Checked Out") {
							System.out.print("That title is currently checked out. Please submit a hold request.");
							break;
						}
						
						if(j.getLocation() == "On Shelf") {
							String checkoutPatronName = i.getPatronName();
							j.checkOutBook(checkoutPatronName, checkoutISBN);
							i.addBook(j);
						}
						
						if(j.getLocation() == "On Hold Shelf") {
							boolean patronRequested = false;
							String checkoutPatronName = i.getPatronName();
							if(j.requestedBy == checkoutPatronName) {
								patronRequested = true;
								System.out.print(j.getTitle() + " had been on hold for you. ");
								j.checkOutBook(checkoutPatronName, checkoutISBN);
								i.addBook(j);
							}
							if(patronRequested == false) {
								System.out.println("That title is already on hold. Please check back later.");
							}
						}
						}
						
					}
				}
				if(bookInList == false) {
					System.out.println("Book is not in library's database.");
				}
			}
			}
		}
		if (patronInList == false) {
			System.out.println("The patron is not in the library's database");
		}
		}
	

	public void returnBook() {
		//update the Book's location (and possibly requestedBy) 
		//depending on whether another Patron has requested it;
		Scanner returnScanner = new Scanner(System.in);
		boolean patronInList = false;
		boolean bookInList = false;
		
		if (patronList.isEmpty() == true) {
			System.out.println("No patrons library's database.");
		}
		
		else {
			System.out.println("Please enter your patron ID: ");
			int patronReturnID = returnScanner.nextInt();
			
		for(Patron i : patronList ) {
			
			if (i.getPatronID() == patronReturnID) {
				patronInList = true;
				
				if (bookList.isEmpty() == true) {
					System.out.println("No books in library's database.");
					break;
				}
					
				else {
					System.out.print("Please enter the ID of the book you are returning: ");
					int returnISBN = returnScanner.nextInt();
				for(Book j : bookList ) {
					if (j.getBookISBN() == returnISBN) {
						bookInList = true;
						j.getLocation();
						if(j.getLocation() == "Checked Out") {
							if(j.getRequestedBy() == null) {
							String returnPatronName = i.getPatronName();
							j.returnBook(returnPatronName, returnISBN);
							i.removeBook(j);
							System.out.println("");
							//break;
							}
							if(j.getRequestedBy()!= null) {
								System.out.println("This book has a hold request");
							}
						}
						if(j.getLocation() != "On Shelf") {
							System.out.println("That title has not been checked out.");
						}
					}
				}
				if (bookInList == false) {
					System.out.println("The book is not in the library's database");
			}
				}
		}
			if (patronInList == false) {
				System.out.println("The patron is not in the library's database");
		}
		
		}
		}
		
	}
	
	
	public void requestBook() {
			Scanner requestScanner = new Scanner(System.in);
			boolean patronInList = false;
			boolean bookInList = false;
			
			if (patronList.isEmpty() == true) {
				System.out.println("No patrons library's database.");
			}
			
			else {
				System.out.println("Please enter your patron ID: ");
				int patronRequestID = requestScanner.nextInt();
				
			for(Patron i : patronList ) {
				
				if (i.getPatronID() == patronRequestID) {
					patronInList = true;
					
					if (bookList.isEmpty() == true) {
						System.out.println("No books in library's database.");
						break;
					}
						
					else {
						System.out.print("Please enter the ID of the book you would like to request: ");
						int checkoutISBN = requestScanner.nextInt();
					for(Book j : bookList ) {
						bookInList = true;
						if (j.getBookISBN() == checkoutISBN) {
							j.getLocation();
							if(j.getLocation() == "On Hold Shelf") {
								System.out.print("That title is already on hold. Please check back later.");
								break;
							}
							if(j.getLocation() == "Checked Out") {
								System.out.print("That title is currently checked out.");
								String requestPatronName = i.getPatronName();
								j.requestBook(requestPatronName);
								System.out.print("That title is now has a hold request in your name. It will be available once the previous patron returns it.");
								System.out.print("");
								break;
							}
							if(j.getLocation() == "On Shelf") {
								String requestPatronName = i.getPatronName();
								j.requestBook(requestPatronName);
								System.out.print("That title now has a hold request in your name and is available for pickup.");
								System.out.println("");
							}
						}
					}
					if (bookInList == false) {
						System.out.println("The book is not in the library's database");
					}
				}
					}
			}
				if (patronInList == false) {
					System.out.println("The patron is not in the library's database");
				}
			
			}

		
	}
	

	public void viewPatron() {
		Scanner viewPatron = new Scanner(System.in);
		boolean patronInList = false;

		System.out.println("Enter patron ID: ");
		int viewPatronID = viewPatron.nextInt();
		
		for(Patron i : patronList ) {
			if (i.getPatronID() == viewPatronID) {
				patronInList = true;
				i.printPatron();
				System.out.println("");
			}
	}
		if (patronInList == false) {
			System.out.println("The patron is not in the library's database");
		}
		
	}
	
	public void viewBook() {
		Scanner viewBook = new Scanner(System.in);
		boolean bookInList = false;

		System.out.println("Enter book ISBN: ");
		int viewBookISBN = viewBook.nextInt();
		
		for(Book i : bookList ) {
			if (i.getBookISBN() == viewBookISBN) {
				bookInList = true;
				i.printBook();
				System.out.println("");
		}

	}
		if (bookInList == false) {
			System.out.println("Book is not in the library's database");
		}
	}
	
	public void payFine() {
		//IF PATRON IS NOT IN LIBRARY PRINT MESSAGE
		boolean patronInList = false;
		Scanner fine = new Scanner(System.in);
		System.out.println("Please enter a patron ID: ");
		int patronFine = fine.nextInt();
		
		for(Patron i : patronList ) {
			if (i.getPatronID() == patronFine) {
				patronInList = true;
				int patronOwes = i.getFine();
				System.out.println(i.getPatronName() +" owes $" + patronOwes);
				System.out.println("Please enter the amount being applied to the fine total (whole dollars only): ");
				int paymentAmount = fine.nextInt();
				i.payFine(paymentAmount);
				System.out.println(i.getPatronName() +" now owes $" + (i.getFine()));
				System.out.println("");
				}
			}
		if (patronInList == false) {
			System.out.println("The patron is not in the library's database");
		}
		}
	
	
	
	
}
	
