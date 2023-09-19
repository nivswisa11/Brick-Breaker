// 208189126 Niv Swisa

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is a decorator which unites all the key presses the stop the game.
 *
 * @author Niv Swisa
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;

    /**
     * this is the constructor of this class.
     *
     * @param sensor    keyboard sensor
     * @param key       string
     * @param animation game animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
