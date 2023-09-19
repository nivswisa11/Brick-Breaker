// 208189126 Niv Swisa

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class creates a block.
 *
 * @author Niv Swisa
 */

public class Block implements Collidable, Sprite, HitNotifier {

    private List<HitListener> hitListeners;
    private Rectangle rec;
    private Color color;

    /**
     * this is a block constructor.
     *
     * @param rectangle receives a rectangle
     * @param color     receives a color
     */
    public Block(Rectangle rectangle, Color color) {
        this.rec = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * this method returns a collision rectangle.
     *
     * @return return a collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * this method changes the velocity of the ball when it hits a collidable block.
     *
     * @param collisionPoint  a collision point of the ball with a block
     * @param hitter          the ball that hits the block
     * @param currentVelocity current velocity of the ball
     * @return return a velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        this.notifyHit(hitter);
        int flagX = 0, flagY = 0;
        //if the collision point x value is the same as the x value on the upper left of the rectangle update flag
        if (Line.doubleEquals(collisionPoint.getX(), this.rec.getUpperLeft().getX())) {
            flagX = 1;
        }
        //if the collision point x value is the same as the x value on the lower right of the rectangle update flag
        if (Line.doubleEquals(collisionPoint.getX(), this.rec.getLowerRight().getX())) {
            flagX = 1;
        }
        //if the collision point y value is the same as the y value on the upper left of the rectangle update flag
        if (Line.doubleEquals(collisionPoint.getY(), this.rec.getUpperLeft().getY())) {
            flagY = 1;
        }
        //if the collision point y value is the same as the y value on the lower right of the rectangle update flag
        if (Line.doubleEquals(collisionPoint.getY(), this.rec.getLowerRight().getY())) {
            flagY = 1;
        }
        //if the x and y values match change both velocities
        if (flagX == 1 && flagY == 1) {
            return new Velocity(dx * (-1), dy * (-1));
            //if only the x values match change the dx
        } else if (flagX == 1) {
            return new Velocity(dx * (-1), dy);
            //if only the y values match change the dy
        } else if (flagY == 1) {
            return new Velocity(dx, dy * (-1));
        }
        //if none of them match return the same velocity as received
        return currentVelocity;
    }

    /**
     * this method draws the outline of the block and the block filling.
     *
     * @param d drawing surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        //draw the filling of the block
        d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
        d.setColor(Color.BLACK);
        //draw the outline of the block
        d.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }

    /**
     * currently a none active method but this method is targeted to give a lifespan to the block.
     */
    public void timePassed() {
    }

    /**
     * this method adds blocks to the game.
     *
     * @param game game that the block will be added to
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * this method removes a block from the game.
     *
     * @param game game that the block will be added to
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * this method creates a list oh hit listeners.
     *
     * @param hitter the ball that is doing the hitting.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


    /**
     * Add hl as a listener to hit events.
     *
     * @param hl listener to be added to the list
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl listener to be removed to the list
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
