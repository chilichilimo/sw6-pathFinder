package scenario6;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Jay on 20/02/2017.
 */
public class Question {
	private ArrayList<Point2D> robots;
	private ArrayList<Obstacle> obstacles;
	private String question;
	private boolean hasObstacles; // TODO: 20/02/2017 Do we want this?
	private int number;
	private ArrayList<Point2D> solution;

	public Question(String question) {
		this.number = Character.getNumericValue(question.charAt(0));
		String tmp = question.replaceAll(" ", "");
		this.question = tmp.substring(2);
		setQuestion();
	}

	public ArrayList<Point2D> getRobots() {
		return robots;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	private void setQuestion() {
		System.out.println(number);
		int robotSeparator = question.indexOf('#');
		if (robotSeparator > -1) {
			hasObstacles = true;
//			setRobots(question.substring(0, robotSeparator));
//			setObstacles(question.substring(robotSeparator + 1));
		} else {
			hasObstacles= false;
			setRobots(question);
		}

		String tmp = question.substring(robotSeparator + 1);
	}


	private void setRobots(String robotString) {
		robots = getCoordsFromString(robotString);
	}

	private void setObstacles(String obstacleString) {
		obstacles = new ArrayList<Obstacle>();
		String[] obstacleStrings = obstacleString.split(";");

		for (String s : obstacleStrings) {
			Obstacle obstacle = new Obstacle(getCoordsFromString(s));
			obstacles.add(obstacle);
		}
	}

	public int getNumber() {
		return number;
	}

	private ArrayList<Point2D> getCoordsFromString(String coords) {
		System.out.println(coords);
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		String[] strings = coords.split(",");

		for (String s : strings) {
			System.out.print(s);
		}

//		int numsGathered = 0;
//		double xCoord = 0;
//		double yCoord = 0;
//		while (in.hasNextDouble()) {
//			System.out.println("Test2");
//			if (numsGathered % 2 == 0) {
//				xCoord = in.nextDouble();
//			} else {
//				yCoord = in.nextDouble();
//				Point2D point = new Point2D.Double(xCoord, yCoord);
//				points.add(point);
//			}
//		}

		return points;
	}

	public void setSolution(ArrayList<Point2D> solution) {
		this.solution = solution;
	}

}
