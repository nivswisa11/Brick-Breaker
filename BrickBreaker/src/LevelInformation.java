// 208189126 Niv Swisa

import java.util.List;

/**
 * this Interface is in charge of providing all the necessary information to the level.
 *
 * @author Niv Swisa
 */
public interface LevelInformation {
    /**
     * this method return the number of balls in the level.
     *
     * @return integer value of balls in the game
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the paddle speed.
     *
     * @return integer value of paddle speed
     */
    int paddleSpeed();

    /**
     * return the paddle width.
     *
     * @return integer value of paddle width
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return string representing the level name
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return Returns a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the list of blocks
     */
    List<Block> blocks();

    /**
     * return the list of balls in the level.
     *
     * @return list of balls
     */
    List<Ball> balls();

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return number of blocks in an integer value
     */
    int numberOfBlocksToRemove();
}