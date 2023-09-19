// 208189126 Niv Swisa

/**
 * this class creates velocity. Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Niv Swisa
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * velocity constructor.
     *
     * @param dx x-axis direction
     * @param dy y-axis direction
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p point value
     * @return return new point according to dx and dy
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * make the dx move the opposite direction.
     */
    public void setMinusDx() {
        this.dx *= -1;
    }

    /**
     * make the dy move the opposite direction.
     */
    public void setMinusDy() {
        this.dy *= -1;
    }

    /**
     * apply speed and direction to the ball movement for velocity.
     *
     * @param angle double value of an angle of the ball movement
     * @param speed double value of the speed of the ball movement
     * @return return a velocity value
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //calculate dx
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        //calculate dy
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * return the dx value.
     * @return return the dx in the velocity
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * return the dy value.
     * @return return the dy in the velocity
     */
    public double getDy() {
        return this.dy;
    }
}