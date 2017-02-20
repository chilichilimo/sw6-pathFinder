package scenario6;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Jay on 20/02/2017.
 */
public class Question {
	private ArrayList<Point2D> robots;
	private ArrayList<Obstacle> obstacles;
	private String question;
	private boolean hasObstacles;
	private int number;

	public Question(String question) {
		this.number = Character.getNumericValue(question.charAt(0));
		this.question = question.substring(3);
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
			setRobots(question.substring(0, robotSeparator));
			setObstacles(question.substring(robotSeparator + 1));
		} else {
			hasObstacles= false;
			setRobots(question);
		}

		String tmp = question.substring(robotSeparator + 1);
	}


	private void setRobots(String robotString) {
		System.out.println(robotString);
		robots = getCoordsFromString(robotString);
	}

	private void setObstacles(String obstacleString) {
		System.out.println(obstacleString);
	}

	public int getNumber() {
		return number;
	}

	private ArrayList<Point2D> getCoordsFromString(String coords) {
		ArrayList<Point2D> points;



		return points
	}
}
