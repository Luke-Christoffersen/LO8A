// Luke Christoffersen, Aidan Schiefer
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<>();

	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};

	private void loadDataFile(String fileName) throws FileNotFoundException {
		// Create a file reader
		FileReader reader = new FileReader(fileName);

		// Create a scanner
		Scanner in = new Scanner(reader);

		// String variables to hold line, scoreText, student name, and score
		String studentName = "";
		String studentScoreHolder = "";
		String line = "";
		int studentScore = 0;

		// Loop through the file
		while (in.hasNextLine()) {
			// Store line for exception handling 
			line = in.nextLine().trim();
			// Grab last space per line so we can find the score
			int lastSpace = line.lastIndexOf(' ');

			studentName = line.substring(0, lastSpace).trim();
			studentScoreHolder = line.substring(lastSpace + 1);

			try {
				// try to make score into int, if fails will trigger exception
				studentScore = Integer.parseInt(studentScoreHolder);
				students.add(new Student(studentName, studentScore));
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + studentName + " not a valid score: " + studentScoreHolder);
				System.out.println();
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


