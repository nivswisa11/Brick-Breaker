// 208189126 Niv Swisa

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class creates the pause screen of the game.
 *
 * @author Niv Swisa
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * pause screen constructor.
     *
     * @param k keyboard sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}