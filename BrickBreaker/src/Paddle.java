// 208189126 Niv Swisa

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * this class creates a paddle.
 *
 * @author Niv Swisa
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rec;

    /**
     * paddle constructor.
     *
     * @param rec receive a rectangle
     * @param keyboard receive a keyboard sensor
     */
    public Paddle(Rectangle rec, KeyboardSensor keyboard) {
        this.rec = rec;
        this.keyboard = keyboard;
    }

    /**
     * this method makes the paddle move left when pressing the left arrow in the keyboard.
     */
    public void moveLeft() {
        //if the left arrow key is pressed
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            //if the paddle is still in the range of the block borders
            if (this.rec.getUpperLeft().getX() > 20) {
                //update paddle movement to the left
                this.rec = this.rec.paddleMove(-5);
            }
        }
    }

    /**
     * this method makes the paddle move right when pressing the left arrow in the keyboard.
     */
    public void moveRight() {
        //if the right arrow key is pressed
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            //if the paddle is still in the range of the block borders
            if (this.rec.getUpperRight().getX() < 780) {
                //update paddle movement to the right
                this.rec = this.rec.paddleMove(5);
            }
        }
    }

    /**
     * this will turn on the move left and move right method.
     */
    public void timePassed() {
        //apply on move left
        moveLeft();
        //apple on move right
        moveRight();
    }

    /**
     * this method draws the paddle on the drawing surface.
     *
     * @param d drawing surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        //draw the filling of the paddle
        d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
        d.setColor(Color.BLACK);
        //draw the outline of the rectangle
        d.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }

    /**
     * this method return a collision rectangle.
     *
     * @return return a rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * this method returns the velocity after hitting the paddle, the velocity is divided into five segments.
     * each segment is a different part of the paddle that return a different velocity according to where the ball hit.
     *
     * @param collisionPoint  point that the ball collides with the paddle
     * @param hitter  the ball that hits the paddle
     * @param currentVelocity current velocity of the ball
     * @return return velocity according to where the ball hit the paddle
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //split the paddle into five equal segments
        double splitToFive = this.rec.getWidth() / 5;
        //set where the first segment ends
        double firstFifth = this.rec.getUpperLeft().getX() + splitToFive;
        //set where the second segment ends
        double secondFifth = firstFifth + splitToFive;
        //set where the third segment ends
        double thirdFifth = secondFifth + splitToFive;
        //set where the fourth segment ends
        double fourthFifth = thirdFifth + splitToFive;
        //set where the last segment ends
        double lastFifth = this.rec.getUpperRight().getX();
        //if the collision is in the first segment update velocity to angle 300
        if (collisionPoint.getX() > this.rec.getUpperLeft().getX() && collisionPoint.getX() <= firstFifth) {
            return Velocity.fromAngleAndSpeed(300, 6);
        }
        //if the collision is in the second segment update velocity to angle 330
        if (collisionPoint.getX() >= firstFifth && collisionPoint.getX() <= secondFifth) {
            return Velocity.fromAngleAndSpeed(330, 6);
        }
        //if the collision is in the third segment multiply the dy by -1
        if (collisionPoint.getX() >= secondFifth && collisionPoint.getX() <= thirdFifth) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        //if the collision is in the fourth segment update velocity to angle 30
        if (collisionPoint.getX() >= thirdFifth && collisionPoint.getX() <= fourthFifth) {
            return Velocity.fromAngleAndSpeed(30, 6);
        }
        //if the collision is in the last segment update velocity to angle 60
        if (collisionPoint.getX() >= fourthFifth && collisionPoint.getX() < lastFifth) {
            return Velocity.fromAngleAndSpeed(60, 6);
        }
        //if the collision is not with the paddle change the dy of the velocity by -1
        return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
    }

    /**
     * this method adds the paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        //add to sprite
        g.addSprite(this);
        //add to collidable
        g.addCollidable(this);
    }
}