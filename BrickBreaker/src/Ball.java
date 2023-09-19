// 208189126 Niv Swisa

import biuoop.DrawSurface;

/**
 * this class creates a ball.
 *
 * @author Niv Swisa
 */
public class Ball implements Sprite {
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private Point p;
    private GameEnvironment environment;

    /**
     * constructor that creates a ball.
     *
     * @param center center point of the ball
     * @param r      radius of the ball
     * @param color  color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.color = color;
        this.r = r;
        this.p = center;
    }

    /**
     * constructor that creates a ball.
     *
     * @param x     x value of the center point
     * @param y     y value of the center point
     * @param r     radius of the ball
     * @param color color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.color = color;
        this.r = r;
        this.p = new Point(x, y);
    }

    /**
     * provides the x value of a point.
     *
     * @return x value of a point
     */
    public int getX() {
        return (int) this.p.getX();

    }

    /**
     * provides the y value of a point.
     *
     * @return y value of a point
     */
    public int getY() {
        return (int) this.p.getY();
    }

    /**
     * provides the radius of a ball.
     *
     * @return ball radius
     */
    public int getSize() {
        return this.r;
    }

    /**
     * provides the color of a ball.
     *
     * @return ball color
     */
    public java.awt.Color getColor() {
        return color;
    }

    // draw the ball on the given DrawSurface

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface drawing surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        //set filling
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     * applies the moveOneStep method on Ball.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * adds the ball to the game.
     *
     * @param game game that the ball will be added to
     */
    public void addToGame(GameLevel game) {
        this.environment = game.getEnvironment();
        game.addSprite(this);
    }

    /**
     * sets ball velocity.
     *
     * @param v velocity variable
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * sets angles for ball movement.
     *
     * @param dx x angle
     * @param dy y angle
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * get ball velocity.
     *
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * makes the ball move according to the velocity.
     */
    public void moveOneStep() {
        //set constant velocity in the start of the game
        if (this.getVelocity() == null) {
            this.setVelocity(4, 4);
        }
        Line line = new Line(this.p.getX(), this.p.getY(), this.p.getX() + getVelocity().getDx(),
                this.p.getY() + getVelocity().getDy());
        //if there is a collision point change the velocity when reaching the point
        if (this.environment.getClosestCollision(line) != null) {
            this.setVelocity(this.environment.getClosestCollision(line).collisionObject().hit(this,
                    this.environment.getClosestCollision(line).collisionPoint(), this.getVelocity()));
        }
        //update velocity to next step
        this.p = this.getVelocity().applyToPoint(this.p);
    }

    /**
     * this method removes the ball from the game.
     * @param game the game that is played
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
