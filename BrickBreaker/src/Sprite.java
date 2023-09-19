// 208189126 Niv Swisa

import biuoop.DrawSurface;

/**
 * this Interface is in charge of all the sprites in the game.
 *
 * @author Niv Swisa
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d drawing surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add the sprites to the game.
     *
     * @param game the game
     */
    void addToGame(GameLevel game);
}