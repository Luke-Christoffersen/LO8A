import java.io.*;
import java.util.ArrayList;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	private void loadDataFile(String fileName) throws FileNotFoundException{
		// Create a file reader
		FileReader reader = new FileReader(fileName);
	}
	
	private void printInOrder() {
		// Sort the students array
		for (Student student1: students) {
			for (Student student2: students) {
				// If student1 is less than student2, print student 1
				if (student1.compareTo(student2) == 0) {
					// Print out the smaller student
					System.out.println(student1);
				}
			}
		}
	}
	
	private void processFiles() {
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker scoreTrakker = new ScoreTrakker();
		scoreTrakker.processFiles();
	}
}


