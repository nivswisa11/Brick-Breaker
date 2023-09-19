// 208189126 Niv Swisa

import java.util.ArrayList;
import java.util.List;

/**
 * this abstract class defines what needs to be at every level in the game.
 *
 * @author Niv Swisa
 */
public abstract class LevelMaster implements LevelInformation {
    private int numberOfBalls;
    private int paddleSpeed;
    private int paddleWidth;
    private int numberOfBlocksToRemove;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private List<Ball> balls;
    private List<Velocity> initialBallVelocities;

    /**
     * this is the level master constructor.
     */
    public LevelMaster() {
        this.initialBallVelocities = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.balls = new ArrayList<>();
    }

    /**
     * this method return the number of balls in the level.
     *
     * @return integer value of balls in the game
     */
    public int numberOfBalls() {
        return this.initialBallVelocities.size();
    }

    /**
     * The initial velocity of each ball.
     *
     * @return list of velocities
     */
    public List<Velocity> initialBallVelocities() {
        return this.initialBallVelocities;
    }

    /**
     * this method sets the values of the paddle in the level.
     *
     * @param speed paddle speed
     * @param width paddle width
     */
    public void setPaddleValues(int speed, int width) {
        this.paddleSpeed = speed;
        this.paddleWidth = width;
    }

    /**
     * return the paddle speed.
     *
     * @return integer value of paddle speed
     */
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * return the paddle width.
     *
     * @return integer value of paddle width
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * sets the name of the level.
     *
     * @param name a string that represents the name of the level
     */
    public void setLevelName(String name) {
        this.levelName = name;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return string representing the level name
     */
    public String levelName() {
        return this.levelName;
    }

    /**
     * set the background of the level.
     *
     * @param background a block that is a sprite
     */
    public void setBackground(Sprite background) {
        this.background = background;
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return Returns a sprite with the background of the level
     */
    public Sprite getBackground() {
        return this.background;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the list of blocks
     */
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return number of blocks in an integer value
     */
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }

    /**
     * adds blocks to the block list.
     *
     * @param block the block that is added to the list
     */
    public void addToBlockList(Block block) {
        this.blocks.add(block);
    }

    /**
     * return the list of balls in the level.
     *
     * @return list of balls
     */
    public List<Ball> balls() {
        return this.balls;
    }

    /**
     * adds balls to the ball list.
     *
     * @param ball the ball that is added to the list
     */
    public void addToBallsList(Ball ball) {
        this.balls.add(ball);
        this.initialBallVelocities.add(ball.getVelocity());
    }
}
