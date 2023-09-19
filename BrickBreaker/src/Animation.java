// 208189126 Niv Swisa

import biuoop.DrawSurface;

/**
 * this interface is in charge of the animation in the game.
 *
 * @author Niv Swisa
 */
public interface Animation {
    /**
     * this method draws the animation on every frame.
     *
     * @param d drawing surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * this method determines if the game should or shouldn't stop.
     *
     * @return true of false
     */
    boolean shouldStop();
}