package scenario6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by Jay on 20/02/2017.
 */
public class RobotsParser {
	private Scanner scanner;
	private File file;
	private boolean remainingQuestions = true;

	public RobotsParser(String fileName) {
		try {
			file = new File(fileName);
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getQuestion() {
		String question = scanner.nextLine();
		remainingQuestions = scanner.hasNextLine();

		System.out.println(question);
	}

	public boolean hasNextQuestion() {
		return remainingQuestions;
	}

	private void getRobots(String question) {
		int robotSeparator = question.indexOf(';');
		System.out.println(question.substring(0,robotSeparator));
	}
}
