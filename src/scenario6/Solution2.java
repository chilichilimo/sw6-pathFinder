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
        Boolean result = false;
        return result;
    }

    //FIXME: Implement this.
    //Checks if a line has any intersection with all obstacles.
    Boolean checkIntersectionWithObstacles(Line2D line, Question question){
        Boolean result = false;
        return result;
    }

    
    //FIXME: Implement this.
    ArrayList<ArrayList<Point2D>> solve(Question question){
        ArrayList<ArrayList<Point2D>> result = new ArrayList<ArrayList<Point2D>>();
        return result;
    }

}
