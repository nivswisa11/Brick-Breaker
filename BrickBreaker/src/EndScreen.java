// 208189126 Niv Swisa

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * this class creates the end screen of the game, a different screen for a win or loss.
 *
 * @author Niv Swisa
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private boolean successOrDefeat;

    /**
     * this is the end screen constructor.
     *
     * @param k               sensor for keyboard
     * @param score           score at the end of the game
     * @param successOrDefeat true for win false for lose
     */
    public EndScreen(KeyboardSensor k, Counter score, boolean successOrDefeat) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.successOrDefeat = successOrDefeat;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        //if the player won print a winning screen
        if (successOrDefeat) {
            d.drawText(320, 275, "You Win!", 32);
            d.drawText(280, 325, "Your score is " + this.score.getValue(), 32);
            //if the player lost print a losing screen
        } else {
            d.drawText(320, 275, "Game Over.", 30);
            d.drawText(280, 325, "Your score is " + this.score.getValue(), 32);
        }
        //if the player presses the space key stop and end the game
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
