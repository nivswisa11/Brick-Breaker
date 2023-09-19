// 208189126 Niv Swisa

/**
 * this Interface is in charge of all the collidables in the game.
 *
 * @author Niv Swisa
 */
public interface Collidable {

    /**
     * Returns the "collision shape" of the object.
     *
     * @return Return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  collision point of the ball
     * @param hitter  the ball that hits the blocks
     * @param currentVelocity current ball velocity
     * @return return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}