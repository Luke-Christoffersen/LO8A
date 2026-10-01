import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList();
	
	private void loadDataFile(String fileName){
		try {
			// Create a file reader
			FileReader reader = new FileReader(fileName);
			
			// Create a scanner
			Scanner in = new Scanner(reader);
			
			// String variables to hold student name and score
			String studentName = "";
			String studentScoreHolder = "";
			int studentScore = 0;
			
			// Loop through the file
			while (in.hasNext()) {
				// Check if the input is an int
				if(in.hasNextInt()) {
					// Extract the integer score
					studentScoreHolder = in.next();
					studentScore = Integer.parseInt(studentScoreHolder);
					
					// Add a new student to the list, trimming off the last extra space
					students.add(new Student(studentName.trim(), studentScore));
					
					// Clear out student name and score
					studentName = "";
					studentScoreHolder = "";
					studentScore = 0;
				}
				else {
					// Get the part of the student name plus a space
					studentName += in.next() + ' ';
				}
			}
			
			// Close out in
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
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
		scoreTrakker.loadDataFile("students.txt");
		scoreTrakker.printInOrder();
	}
}


