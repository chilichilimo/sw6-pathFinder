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
	private boolean hasObstacles; // TODO: 20/02/2017 Do we want this?
	private int number;
	private ArrayList<ArrayList<Point2D>> solution;

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
		int robotSeparator = question.indexOf('#');
		if (robotSeparator > -1) {
			hasObstacles = true;
			setRobots(question.substring(0, robotSeparator));
			setObstacles(question.substring(robotSeparator + 1));
		} else {
			hasObstacles= false;
			setRobots(question);
		}
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

	public int getQNumber() {
		return number;
	}

	private ArrayList<Point2D> getCoordsFromString(String coords) {
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		String filtered = coords.replaceAll("[()]", "");
		String[] numbers = filtered.split(",");

		for (int i=0; i<numbers.length; i+=2) {
			Point2D point2D = new Point2D.Double(Double.parseDouble(numbers[i]), Double.parseDouble(numbers[i + 1]));
			points.add(point2D);
		}

		return points;
	}

	public void setSolution(ArrayList<ArrayList<Point2D>> solution) {
		this.solution = solution;
	}

	public ArrayList<ArrayList<Point2D>> getSolution() {
		return solution;
	}

	public boolean hasObstacles() {
		return hasObstacles;
	}
}
