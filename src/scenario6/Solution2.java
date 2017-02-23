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
    //Checks if two lines have intersection.
    Boolean haveIntersection(Line2D l1, Line2D l2){
        boolean result = l2.intersectsLine(l1);
        return result;
    }

    //Checks if a line has any intersection with all obstacles.
    // TODO: 23/02/2017 Considering returning the obstacle line that causes the intersection for use in the route
    // TODO: 23/02/2017 compensation code (get methods can be used on line objects)
    Boolean hasIntersectionWithObstacles(Line2D line, ArrayList<Obstacle> obstacles){
        Boolean result = false;

        for (Obstacle o : obstacles) {
            for (int i=0; i<o.getVertices().size() - 1; i++) {
                Line2D obstacleLine = new Line2D.Double(o.getVertices().get(i), o.getVertices().get(i + 1));
                if (haveIntersection(line, obstacleLine)){
                    result = true;
                    return result;
                }
            }
        }

        return result;
    }

    //FIXME: Implement this.
    ArrayList<Point2D> nodesPathFinder(Point2D a, Point2D target, ArrayList<Obstacle> obstacles){
        ArrayList<Point2D> result = new ArrayList<Point2D>();
        Point2D start = a;
        Point2D end = target;
        result.add(start);
        Line2D lineab = new Line2D.Double(start, end);
        if (hasIntersectionWithObstacles(lineab, obstacles)) {
            // Route compensation code here

        }
//        Line2D ab = new Line2D() {
//            @Override
//            public double getX1() {
//                return a.getX();
//            }
//
//            @Override
//            public double getY1() {
//                return a.getX();
//            }
//
//            @Override
//            public Point2D getP1() {
//                return a;
//            }
//
//            @Override
//            public double getX2() {
//                return b.getX();
//            }
//
//            @Override
//            public double getY2() {
//                return b.getY();
//            }
//
//            @Override
//            public Point2D getP2() {
//                return b;
//            }
//
//            @Override
//            public void setLine(double x1, double y1, double x2, double y2) {
//            }
//
//            @Override
//            public Rectangle2D getBounds2D() {
//                return null;
//            }
//        };

        return result;

    }

    ArrayList<ArrayList<Point2D>> solve(Question question){
        ArrayList<ArrayList<Point2D>> result = new ArrayList<ArrayList<Point2D>>();
        if (question.hasObstacles()) {
            ArrayList<Point2D> pathFoundToNextNode = new ArrayList<Point2D>();
            for (int i = 0; i < question.getRobots().size() - 1; i++) {
                pathFoundToNextNode.addAll(nodesPathFinder(question.getRobots().get(i), question.getRobots().get(i + 1), question.getObstacles()));
            }
            result.add(pathFoundToNextNode);
        } else {
            result.add(question.getRobots());
        }
        return result;
    }

}
