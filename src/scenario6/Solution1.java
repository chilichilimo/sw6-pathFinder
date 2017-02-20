package scenario6;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created on 20/02/2017.
 * This file includes the first solution to scenario week 6 problem.
 * Freeze-tag part: It's Naive, we move from A to B to C to... .
 * Obstacle part: We make a visibility graph(remember that each edge has a cost.) We then Apply Dijkstra to A and B and we receive the nodes for the path. We then move to Node C and so on.
 */

public class Solution1 {

    //Make visibility graph from Question.
    Graph graphCreator(Question question){
        //FIXME: Implement the visibility graph creator.
        Graph graph = new Graph();
        return graph;
    }

    //Apply Dijkstra, create the ArrayList of final coordinates.
    ArrayList<ArrayList<Point2D>> solution(){
        ArrayList<ArrayList<Point2D>> result = new ArrayList<ArrayList<Point2D>>();
        return result;
    }

}
