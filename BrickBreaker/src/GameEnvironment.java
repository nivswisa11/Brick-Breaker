// 208189126 Niv Swisa

import java.util.ArrayList;
import java.util.List;

/**
 * this class creates a game environment.
 *
 * @author Niv Swisa
 */

public class GameEnvironment {
    private List<Collidable> collisionsList;

    /**
     * game environment constructor.
     */
    public GameEnvironment() {
        this.collisionsList = new ArrayList<>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.collisionsList.add(c);
    }

    /**
     * remove a collidable from the environment.
     * @param c coliidable
     */
    public void removeCollidable(Collidable c) {
        this.collisionsList.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end(). If this object will not collide with any of the
     * collidables in this collection, return null. Else, return the information about the closest collision that is
     * going to occur.
     *
     * @param trajectory the course of the ball
     * @return return the closest collision point to the start of the trajectory and the collision object
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //create a list of points
        ArrayList<Point> pointList = new ArrayList<>();
        //create a list of integers for storing point locations
        ArrayList<Integer> integers = new ArrayList<>();
        //if there are no collisions return null
        if (this.collisionsList.isEmpty()) {
            return null;
        }
        //if there is an intersection with the trajectory, add point to point and integer lists
        for (int i = 0; i < collisionsList.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(
                    this.collisionsList.get(i).getCollisionRectangle()) != null) {
                //add point of intersection to point list
                pointList.add(trajectory.closestIntersectionToStartOfLine(
                        this.collisionsList.get(i).getCollisionRectangle()));
                //add the location of the point in the collision list to the integer list
                integers.add(i);
            }
        }
        //if the point list if empty return null
        if (pointList.isEmpty()) {
            return null;
        }
        Point minPointListIntersection = pointList.get(0);
        double minPointList = trajectory.start().distance(pointList.get(0));
        int tempIndex = 0;
        //find the collision point closest to the start of the trajectory line
        for (int i = 0; i < pointList.size(); i++) {
            //if the point is closer to the start than the other point
            if (trajectory.start().distance(pointList.get(i)) <= minPointList) {
                //update the distance to the closest point
                minPointList = trajectory.start().distance(pointList.get(i));
                //save the point
                minPointListIntersection = pointList.get(i);
                //save the location of the point in the point list
                tempIndex = integers.get(i);
            }
        }
        //take the closest point found in the collision list and return it
        CollisionInfo colInfo = new CollisionInfo(minPointListIntersection, this.collisionsList.get(tempIndex));
        return colInfo;
    }
}