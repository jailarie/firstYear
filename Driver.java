import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("classes_mod.csv");
		Scanner scanner = new Scanner(input);
		BinarySearchTree<String, MSUClass> classes = new BinarySearchTree<String, MSUClass>();
		while (scanner.hasNext()) {
            String line = scanner.nextLine();
            MSUClass current = new MSUClass(line);
            if(current.isLecture() == true) {
            	String currentKey = current.getKey();
            	classes.put(currentKey, current);
               	current.printObject();
            	System.out.println(" " + current.getKey());
            }

		}
	}


}
