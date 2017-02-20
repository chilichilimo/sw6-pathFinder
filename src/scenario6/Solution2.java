package scenario6;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created on 20/02/2017.
 * Freeze-Tag part: Naive. A->B->C->...
 * Robot-Motion-Planning: Over every iteration, if AB passes through any line of any obstacle, apply the algorithm to the
 */

public class Solution2 {

    //FIXME: Implement this.
    //Checks if two lines have intersection.
    Boolean haveIntersection(Line2D l1, Line2D l2){

        Line2D line1 = new Line2D.Float(100, 100, 200, 200);
        Line2D line2 = new Line2D.Float(150, 150, 150, 200);
        boolean result = line2.intersectsLine(line1);
        System.out.println(result); // => true
        
        System.out.println(Line2D.linesIntersect(100,100,200,200,150,150,150,200));

        //Boolean result = false;
        return result;
    }

    //FIXME: Implement this.
    //Checks if a line has any intersection with all obstacles.
    Boolean hasIntersectionWithObstacles(Line2D line, Question question){
        Boolean result = false;
        return result;
    }

    //FIXME: Implement this.
    ArrayList<Point2D> nodesPathFinder(Point2D a, Point2D b, Question question){
        ArrayList<Point2D> result = new ArrayList<Point2D>();
        Point2D start = a;
        Point2D end = b;
        result.add(a);
        Line2D ab = new Line2D() {
            @Override
            public double getX1() {
                return a.getX();
            }

            @Override
            public double getY1() {
                return a.getX();
            }

            @Override
            public Point2D getP1() {
                return a;
            }

            @Override
            public double getX2() {
                return b.getX();
            }

            @Override
            public double getY2() {
                return b.getY();
            }

            @Override
            public Point2D getP2() {
                return b;
            }

            @Override
            public void setLine(double x1, double y1, double x2, double y2) {

            }

            @Override
            public Rectangle2D getBounds2D() {
                return null;
            }
        };

        if (!hasIntersectionWithObstacles(ab, question)){

        }

        while(end != b){

        }
        return result;

    }

    ArrayList<ArrayList<Point2D>> solve(Question question){
        ArrayList<ArrayList<Point2D>> result = new ArrayList<ArrayList<Point2D>>();
        for (int i = 0; i < question.getRobots().size()-1; i++) {
            ArrayList<Point2D> pathFoundToNextNode = new ArrayList<Point2D>();
            pathFoundToNextNode = nodesPathFinder(question.getRobots().get(i),question.getRobots().get(i+1),question);
            result.add(pathFoundToNextNode);
        }
        return result;
    }

}
