package scenario6;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Jay on 20/02/2017.
 */
public class Question {
	private ArrayList<Point2D> robots;
	private ArrayList<Obstacle> obstacles;
	private String question;

	public Question(String question) {
		this.question = question;
	}

	public ArrayList<Point2D> getRobots() {
		return robots;
	}

	public ArrayList<ArrayList<Point>> getObstacles() {
		return obstacles;
	}

	private void setQuestion() {
		int robotSeparator = question.indexOf('#');
		if (robotSeparator > -1) {
			currentQuestionHasObstacle = true;
			System.out.println(question.substring(0, robotSeparator));
		}

		String tmp = question.substring(robotSeparator + 1);
		currentQuestion = tmp;
	}

	private void setRobots(String robotString) {

	}

	private void setObstacles(String obstacleString) {

	}
}
