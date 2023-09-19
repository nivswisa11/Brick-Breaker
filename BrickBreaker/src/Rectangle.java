// 208189126 Niv Swisa

import java.util.ArrayList;
import java.util.List;

/**
 * this class creates a rectangle.
 *
 * @author Niv Swisa
 */

public class Rectangle {

    private Point upperLeft;
    private Point upperRight;
    private Point lowerLeft;
    private Point lowerRight;
    private double width;
    private double height;
    private Line yAxisParallelLeft;
    private Line yAxisParallelRight;
    private Line xAxisParallelTop;
    private Line xAxisParallelBottom;

    /**
     * constructor that builds a rectangle.
     *
     * @param upperLeft the upper lest point of the rectangle
     * @param width     double value of the rectangle width
     * @param height    double value of the rectangle height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        this.lowerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        this.lowerRight = new Point(this.upperLeft.getX() + width, this.lowerLeft.getY());
        //the left border of the rectangle
        this.yAxisParallelLeft = new Line(this.upperLeft, this.lowerLeft);
        //the right border of the rectangle
        this.yAxisParallelRight = new Line(this.upperRight, this.lowerRight);
        //the top border of the rectangle
        this.xAxisParallelTop = new Line(this.upperLeft, this.upperRight);
        //the bottom border of the rectangle
        this.xAxisParallelBottom = new Line(this.lowerLeft, this.lowerRight);
    }

    /**
     * this function updated the movement of the paddle according to the new points.
     *
     * @param move double value of how much left or right to move
     * @return return a rectangle in the new location of the paddle after the movement
     */
    public Rectangle paddleMove(double move) {
        return new Rectangle(new Point(this.upperLeft.getX() + move, this.upperLeft.getY()),
                this.width, this.height);
    }

    /**
     * this function stores all the possible intersection point according to the line received in a list.
     *
     * @param line a line that is the trajectory of the ball
     * @return Return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //create a new list
        List<Point> intersectionList = new ArrayList<Point>();
        //if the line intersects with the left border of the rectangle add to list
        if (this.yAxisParallelLeft.intersectionWith(line) != null) {
            intersectionList.add(this.yAxisParallelLeft.intersectionWith(line));
        }
        //if the line intersects with the right border of the rectangle add to list
        if (this.yAxisParallelRight.intersectionWith(line) != null) {
            intersectionList.add(this.yAxisParallelRight.intersectionWith(line));
        }
        //if the line intersects with the bottom border of the rectangle add to list
        if (this.xAxisParallelBottom.intersectionWith(line) != null) {
            intersectionList.add(this.xAxisParallelBottom.intersectionWith(line));
        }
        //if the line intersects with the top border of the rectangle add to list
        if (this.xAxisParallelTop.intersectionWith(line) != null) {
            intersectionList.add(this.xAxisParallelTop.intersectionWith(line));
        }
        return intersectionList;
    }

    /**
     * this method returns the width of the rectangle.
     *
     * @return return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this method returns the height of the rectangle.
     *
     * @return return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * this method return the upper left point of the rectangle.
     *
     * @return Returns the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * this method return the upper right point of the rectangle.
     *
     * @return Returns the upper-right point of the rectangle.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * this method return the lower left point of the rectangle.
     *
     * @return Returns the lower left point of the rectangle.
     */
    public Point getLowerLeft() {
        return this.lowerLeft;
    }

    /**
     * this method return the lower right point of the rectangle.
     *
     * @return Returns the lower right point of the rectangle.
     */
    public Point getLowerRight() {
        return this.lowerRight;
    }
}