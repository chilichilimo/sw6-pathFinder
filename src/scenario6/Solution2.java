package scenario6;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created on 20/02/2017.
 * Freeze-Tag part: Naive. A->B->C->...
 * Robot-Motion-Planning: Over every iteration, if AB passes through any line of any obstacle, iteratively connect a to
 * any of the obstacle's line's vertices. //TODO: You need to check if the new line passes through any line of any
 * //TODO: through any line of any obstacle as well.
 */

public class Solution2 {

	// TODO: 23/02/2017 Consider if we're aiming for a point on the obstacle, false positive?
	// TODO: Should not make a difference really...
	// TODO: 24/02/2017 False positive when lines touch but don't intersect
	//Checks if two lines have intersection.
	Boolean haveIntersection(Line2D l1, Line2D l2) {
		boolean result = l2.intersectsLine(l1);
		return result;
	}


	//Checks if a line has any intersection with all obstacles.
	// TODO: 23/02/2017 compensation code (get methods can be used on line objects)
	Line2D hasIntersectionWithObstacles(Line2D line, ArrayList<Obstacle> obstacles) {
		Line2D result;
		for (Obstacle o : obstacles) {
			for (int i = 0; i < o.getVertices().size() - 1; i++) {
				Line2D obstacleLine = new Line2D.Double(o.getVertices().get(i), o.getVertices().get(i + 1));
				if (haveIntersection(line, obstacleLine)) {
					result = obstacleLine;
					return result;
				}
			}
		}
		return null;
	}

	Obstacle findObstacleWithLine(Line2D intersectedLine, ArrayList<Obstacle> obstacles) {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).hasLine(intersectedLine)) {
				return obstacles.get(i);
			}
		}

		return null;
	}


	// TODO: Implement this.
	ArrayList<Point2D> nodesPathFinder(Point2D a, Point2D target, ArrayList<Obstacle> obstacles) {
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		Point2D start = a;
		Point2D end = target;
		result.add(start);
		Line2D lineab = new Line2D.Double(start, end);
		Line2D intersectedLine = hasIntersectionWithObstacles(lineab, obstacles);

		boolean hasObstacle;
		do {
//			System.out.println("start: " + start + " end: " + end + " p1: " + intersectedLine.getP1() + " p2: " + intersectedLine.getP2());
			if (intersectedLine != null && !(end.equals(intersectedLine.getP2()))) {
				hasObstacle = true;
				end = intersectedLine.getP2();
				lineab = new Line2D.Double(start, end);
				intersectedLine = hasIntersectionWithObstacles(lineab, obstacles);
			} else {
				hasObstacle = false;
			}
		} while (hasObstacle);

//		System.out.println("end: " + end + " target: " + target);
		if (end != target) {
			start = end;
			result.add(start);
			Obstacle intersectedObstacle = findObstacleWithLine(intersectedLine, obstacles);
			Point2D targetPoint = intersectedObstacle.getVertexClosestToPoint(target);
			while (start != targetPoint) {
				Point2D tmp = intersectedObstacle.getAdjacentVertex(start);
				start = tmp;
				result.add(start);
			}

			lineab = new Line2D.Double(start, target);
			intersectedLine = hasIntersectionWithObstacles(lineab, obstacles);
			if (intersectedLine != null) {
				System.out.println("start: " + start + " target: " + target + " p1: " + intersectedLine.getP1() + " p2: " + intersectedLine.getP2());
//				System.out.println("More work");
			} else {
				System.out.println("Nope");
			}
		}

		return result;

	}

	ArrayList<ArrayList<Point2D>> solve(Question question) {
		System.out.println(question.getQNumber());
		ArrayList<ArrayList<Point2D>> result = new ArrayList<ArrayList<Point2D>>();
		if (question.hasObstacles()) {
			ArrayList<Point2D> pathFoundToNextNode = new ArrayList<Point2D>();
			for (int i = 0; i < question.getRobots().size() - 1; i++) {
				pathFoundToNextNode.addAll(nodesPathFinder(question.getRobots().get(i),
						question.getRobots().get(i + 1), question.getObstacles()));
			}
			pathFoundToNextNode.add(question.getRobots().get(question.getRobots().size() - 1));
			result.add(pathFoundToNextNode);
		} else {
			result.add(question.getRobots());
		}
		return result;
	}

}
