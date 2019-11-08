import java.util.ArrayList;
import java.util.Scanner;

public class MSUClass {
	String title;
	String courseID;
	int seats;
	int sections = 1;
	String dayTimeLocation;
	boolean lecture;
	
	public MSUClass(String line) {
		ArrayList<String> row = new ArrayList<String>();
		Scanner linescanner = new Scanner(line);
		linescanner.useDelimiter(",");
		while (linescanner.hasNext()) {
			String next = linescanner.next();
			 if (next.length() != 0) {
				 row.add(next);
			 }
		}
		this.courseID = row.get(0).substring(0,8);
		this.title = row.get(1);
		this.seats =  Integer.parseInt(row.get(3));
		this.dayTimeLocation = row.get(11) + " " + row.get(12);
		if(row.contains("Lecture") || row.contains("Seminar")) {
			this.lecture = true;
		}else {
			this.lecture = false;
		}

		
	}
	
	public String getKey() {
		return this.dayTimeLocation;
	}
	
	public boolean isLecture() {
		return lecture;
	}
	
	public void incrementSections() {
		this.sections ++;
	}
	public void addSeats(int newSeats) {
		this.seats += newSeats;
	}
	
	public void printObject() {
		System.out.print(this.courseID + " " + this.sections + " " + this.seats + " " + this.title);

	}
}
