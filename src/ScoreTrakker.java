import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<>();

	private String[] files = { "badscore.txt" };

	private void loadDataFile(String fileName) throws FileNotFoundException {
		// Create a file reader
		FileReader reader = new FileReader(fileName);

		// Create a scanner
		Scanner in = new Scanner(reader);

		// String variables to hold student name and score
		String studentName = "";
		String studentScoreHolder = "";
//		String line = "";
		int studentScore = 0;

		// Loop through the file
		while (in.hasNext()) {
			// Store line for exception handling 
//			line = in.nextLine().trim();
			// Check if the input is an int
			if(in.hasNextInt()) {
				try {
					// Extract the integer score
					studentScoreHolder = in.next();
					studentScore = Integer.parseInt(studentScoreHolder);

					// Add a new student to the list, trimming off the last extra space
					students.add(new Student(studentName.trim(), studentScore));

				} catch (NumberFormatException e) {
					System.out.println("Incorrect format for " + studentName + "not a valid score: " + e);
				}
				// Clear out student name line and score
				studentName = "";
				studentScoreHolder = "";
				studentScore = 0;
//				line = "";
			}
			else {
				// Get the part of the student name plus a space
				studentName += in.next() + ' ';
			}
		}

		// Close out in
		in.close();
	}

	private void printInOrder() {
		// Using built in sort method
		Collections.sort(students);
		// Print now that we are sorted
	    for (Student student : students) {
	        System.out.println(student);
	    }
	    students = new ArrayList<>();
	}

	private void processFiles() {
		for (String file : files) {
			try {
				loadDataFile(file);
				printInOrder();
				System.out.println();
			} catch (FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	public static void main(String[] args) {
		ScoreTrakker scoreTrakker = new ScoreTrakker();
		scoreTrakker.processFiles();
	}
}


