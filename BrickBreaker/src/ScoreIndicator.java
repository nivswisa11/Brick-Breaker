// 208189126 Niv Swisa

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * this class prints the score in the game.
 *
 * @author Niv Swisa
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * ScoreIndicator constructor.
     *
     * @param score score counter
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * this method prints the score on the game screen.
     *
     * @param d drawing surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(360, 17, "Score: " + this.score.getValue(), 17);
    }

    /**
     * none.
     */
    public void timePassed() {
    }

    /**
     * this method adds the score line to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}