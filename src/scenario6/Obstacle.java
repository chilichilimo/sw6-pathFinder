package scenario6;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Jay on 20/02/2017.
 */
public class Obstacle {
	ArrayList<Point2D> vertices;

	public Obstacle(ArrayList<Point2D> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Point2D> getVertices() {
		return vertices;
	}

	public Point2D getAdjacentVertex(Point2D point2D) {
		int pos = vertices.indexOf(point2D);

		return vertices.get((pos + 1) % vertices.size());
	}

	public Point2D getVertexClosestToPoint(Point2D point2D, Point2D target) {
		double minDistance = Double.MAX_VALUE;
		int minPos = -1;
		for (int i=0; i<vertices.size(); i++) {
			double distance = Math.sqrt(
					(target.getX() - vertices.get(i).getX()) * (target.getX() - vertices.get(i).getX())
					+ (target.getY() - vertices.get(i).getY() * (target.getY() - vertices.get(i).getY()))
			);
			if (distance < minDistance) {
				minDistance = distance;
				minPos = i;
			}
		}

		return vertices.get(minPos);
	}

	public boolean hasLine(Line2D line) {
		if (vertices.contains(line.getP1()) && vertices.contains(line.getP2())) {
			return true;
		} else {
			return false;
		}
	}
}
