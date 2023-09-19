// 208189126 Niv Swisa

/**
 * this class creates point on a coordinate system.
 *
 * @author Niv Swisa
 */
public class Point {
    private double x;
    private double y;

    /**
     * point constructor.
     *
     * @param x x value of a point
     * @param y y value of a point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculates distance between two points.
     *
     * @param other point
     * @return return the distance of this point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));

    }

    /**
     * checks if two points are equal.
     *
     * @param other point
     * @return return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (Line.doubleEquals(this.x, other.x) && Line.doubleEquals(this.y, other.y)) {
            return true;
        }
        return false;
    }

    /**
     * @return Return the x value of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return return the y value of the point
     */
    public double getY() {
        return this.y;
    }
}