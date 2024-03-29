package scenario6;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static void solve(Question question) {
		// Write algorithm here
	}

	private static void printSolution(PrintWriter writer, String original, Question question) {
		writer.print(question.getQNumber() + ":");
		if (question.getSolution() != null) {
			ArrayList<ArrayList<Point2D>> solution = question.getSolution();
			for (ArrayList<Point2D> path : solution) {
				for (Point2D point : path) {
					writer.print(" (");
					writer.print(point.getX() + ", ");
					writer.print(point.getY() + ")");
				}
				if (question.hasObstacles()) {
					writer.print(";");
				}
			}
		} else {
			writer.println("Missing solution.");
		}
	}

	public static void main(String[] args) {
		// write your code here
		File file;
		Scanner scanner;
		PrintWriter writer;

		try {
			file = new File("robots.mat");
			scanner = new Scanner(file);
			writer = new PrintWriter("solution.txt");

			writer.println("fenrir");
			writer.println("u8jtthcbiceg1srsotj60fg588");

			int i = 0;
			while (scanner.hasNextLine() && i < 4) {
				i++;
				String q = scanner.nextLine();
				Question question = new Question(q);
				solve(question);

				printSolution(writer, q, question);
			}

			writer.close();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
