package scenario6;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
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

        // Also check out linesIntersect() if you do not need to construct the line objects
        // It will probably be faster due to putting less pressure on the garbage collector
        // if running it in a loop
        System.out.println(Line2D.linesIntersect(100,100,200,200,150,150,150,200));

        //Boolean result = false;
        return result;
    }

    //FIXME: Implement this.
    //Checks if a line has any intersection with all obstacles.
    Boolean checkIntersectionWithObstacles(Line2D line, Question question){
        Boolean result = false;
        return result;
    }

    //FIXME: Implement this.
    ArrayList<Point2D> nodesPathFinder(Point2D a, Point2D b){
        
        ArrayList<Point2D> result = new ArrayList<Point2D>();
        return result;

    }

    ArrayList<ArrayList<Point2D>> solve(Question question){
        ArrayList<ArrayList<Point2D>> result = new ArrayList<ArrayList<Point2D>>();
        for (int i = 0; i < question.getRobots().size()-1; i++) {
            ArrayList<Point2D> pathFoundToNextNode = new ArrayList<Point2D>();
            pathFoundToNextNode = nodesPathFinder(question.getRobots().get(i),question.getRobots().get(i+1));
            result.add(pathFoundToNextNode);
        }
        return result;
    }

}
