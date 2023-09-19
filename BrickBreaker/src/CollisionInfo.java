// 208189126 Niv Swisa

/**
 * this class returns the closest collision point and the collision object.
 *
 * @author Niv Swisa
 */
public class CollisionInfo {
    private Point point;
    private Collidable collidable;

    /**
     * collision info constructor.
     *
     * @param point collision point
     * @param c     collision object
     */
    public CollisionInfo(Point point, Collidable c) {
        this.point = point;
        this.collidable = c;
    }

    /**
     * this method returns the point at which the collision occurs.
     *
     * @return return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * this method returns the collidable object involved in the collision.
     *
     * @return return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}