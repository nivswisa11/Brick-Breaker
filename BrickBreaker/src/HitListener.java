// 208189126 Niv Swisa

/**
 * this Interface is a HitListener.
 *
 * @author Niv Swisa
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the block tha is being hit
     * @param hitter   the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}