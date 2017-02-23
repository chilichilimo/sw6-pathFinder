package scenario6;

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
}
