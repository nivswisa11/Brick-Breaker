// 208189126 Niv Swisa

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.awt.Polygon;

/**
 * this class creates the levels in the game.
 *
 * @author Niv Swisa
 */

public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCount;
    private Counter ballCount;
    private Counter score;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * this is a game level constructor.
     *
     * @param levelInformation the information about the current level
     * @param score            score at the start of the level
     * @param runner           runs the animation in the game
     * @param keyboard         keyboard sensor
     */
    public GameLevel(LevelInformation levelInformation, Counter score, AnimationRunner runner,
                     KeyboardSensor keyboard) {
        //create a new sprite collection
        this.sprites = new SpriteCollection();
        //create a game environment
        this.environment = new GameEnvironment();
        //create a window for the game
        //initialize the blocks counter
        this.blockCount = new Counter(0);
        //initialize the balls counter
        this.ballCount = new Counter(0);
        //initialize the score counter
        this.score = score;
        //create a new animation runner
        this.runner = runner;
        //add keyboard to the game
        this.keyboard = keyboard;
        //add the current level information
        this.levelInformation = levelInformation;
    }

    /**
     * this method adds a collidable object to the game environment.
     *
     * @param c a collidable object
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * this method adds sprites to the sprite.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this method returns a game environment.
     *
     * @return return a game environment.
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * this method removes a collidable object from the game environment.
     *
     * @param c a collidable object
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * this method removes a sprites.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }


    /**
     * Initialize a new game: create the Blocks, Ball and Paddle and adds them to the game.
     */
    public void initialize() {
        int counter = 0;
        //create a blockRemover
        BlockRemover remove = new BlockRemover(this, this.blockCount);
        //create a ballRemover
        BallRemover removeBall = new BallRemover(this, this.ballCount);
        //create a score tracker
        ScoreTrackingListener scoreTracker = new ScoreTrackingListener(this.score);

        //create a new block to display the score and add it to the game
        Block scoreBlock = new Block(new Rectangle(new Point(0, 0), 800, 20), Color.LIGHT_GRAY);
        scoreBlock.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);
        //create and add a block for the borders of the game
        Block b = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.GRAY);
        b.addToGame(this);
        //create and add a block for the borders of the game
        Block b2 = new Block(new Rectangle(new Point(0, 40), 20, 580), Color.GRAY);
        b2.addToGame(this);
        //create and add a death block the removes the balls from the game if they touch it
        Block b3 = new Block(new Rectangle(new Point(0, 600), 800, 20), Color.GRAY);
        b3.addToGame(this);
        b3.addHitListener(removeBall);
        //create and add a block for the borders of the game
        Block b4 = new Block(new Rectangle(new Point(780, 40), 20, 580), Color.GRAY);
        b4.addToGame(this);
        //create a paddle that is keyboard sensitive and add it to the game
        new Paddle(new Rectangle(new Point(400 - (int) (this.levelInformation.paddleWidth() / 2), 560),
                this.levelInformation.paddleWidth(), 20), this.keyboard).addToGame(this);
        //add all the blocks to the game
        for (int i = 0; i < this.levelInformation.blocks().size(); i++) {
            Block block = this.levelInformation.blocks().get(i);
            block.addToGame(this);
            counter++;
            //make the block a listener for the block removal and the score tracking
            block.addHitListener(remove);
            block.addHitListener(scoreTracker);
        }
        //update the number of blocks in the game
        this.blockCount.increase(counter);
        this.createBallsOnTopOfPaddle();
    }

    /**
     * this method draws the background for level 1.
     *
     * @param d drawing surface
     */
    public static void drawLevel1(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE);
        d.drawCircle(400, 200, 50);
        d.drawCircle(400, 200, 80);
        d.drawCircle(400, 200, 110);
        d.setColor(Color.BLUE);
        d.drawLine(380, 200, 260, 200);
        d.drawLine(420, 200, 540, 200);
        d.drawLine(400, 220, 400, 340);
        d.drawLine(400, 60, 400, 180);
    }

    /**
     * this method draws the background for level 2.
     *
     * @param d drawing surface
     */
    public static void drawLevel2(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.GREEN.darker());
        d.fillRectangle(20, 580, 760, 20);
        d.setColor(Color.GRAY);
        d.fillRectangle(60, 460, 120, 120);
        d.setColor(new Color(107, 55, 11));
        d.fillRectangle(100, 520, 40, 60);
        d.setColor(new Color(188, 213, 180));
        d.fillRectangle(70, 475, 30, 30);
        d.fillRectangle(140, 475, 30, 30);
        d.setColor(Color.BLACK);
        d.drawRectangle(20, 580, 760, 20);
        d.drawRectangle(60, 460, 120, 120);
        d.drawRectangle(70, 475, 30, 30);
        d.drawRectangle(140, 475, 30, 30);
        d.drawRectangle(100, 520, 40, 60);
        d.setColor(Color.BLACK);
        d.drawLine(85, 475, 85, 505);
        d.drawLine(155, 475, 155, 505);
        d.drawLine(70, 490, 100, 490);
        d.drawLine(140, 490, 170, 490);
        d.drawLine(260, 525, 260, 580);
        d.setColor(Color.ORANGE.brighter().brighter());
        d.fillCircle(720, 90, 45);
        d.setColor(Color.ORANGE);
        d.fillCircle(720, 90, 35);
        d.setColor(Color.ORANGE);
        d.drawLine(670, 90, 600, 100);
        d.drawLine(680, 120, 620, 150);
        d.drawLine(710, 140, 690, 200);

        for (int i = 0; i < 8; i++) {
            d.setColor(Color.RED);
            d.fillCircle(250 + (i * 50), 520, 10);
            d.fillCircle(260 + (i * 50), 510, 10);
            d.fillCircle(270 + (i * 50), 520, 10);
            d.fillCircle(260 + (i * 50), 530, 10);
            d.setColor(Color.GREEN);
            d.fillCircle(260 + (i * 50), 520, 5);
            d.setColor(Color.BLACK);
            d.drawLine(260 + (i * 50), 540, 260 + (i * 50), 580);
        }
        for (int i = 0; i < 10; i++) {
            d.setColor(Color.BLACK);
            d.drawRectangle(50 + (i * 6), 455 - (i * 5), 140 - (i * 12), 5);
            d.setColor(new Color(188, 213, 180));
            d.fillRectangle(50 + (i * 6), 455 - (i * 5), 140 - (i * 12), 5);
        }
    }

    /**
     * this method draws the background for level 3.
     *
     * @param d drawing surface
     */
    public static void drawDragonBallZLevel(DrawSurface d) {
        d.setColor(new Color(19, 64, 169));
        d.fillRectangle(0, 0, 800, 600);
        //create balls with stars
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(700, 500, 15);
        drawStar(700, 490, 1, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(100, 490, 15);
        drawStar(100, 480, 1, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(200, 500, 45);
        drawStar(200, 480, 3, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(200, 200, 45);
        drawStar(200, 180, 3, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(600, 495, 30);
        drawStar(600, 480, 2, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(400, 100, 30);
        drawStar(400, 85, 2, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(400, 460, 60);
        drawStar(400, 435, 4, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(450, 350, 30);
        drawStar(450, 335, 2, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(750, 70, 15);
        drawStar(750, 60, 1, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(720, 370, 15);
        drawStar(720, 360, 1, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(50, 80, 15);
        drawStar(50, 70, 1, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(70, 320, 15);
        drawStar(70, 310, 1, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(250, 330, 30);
        drawStar(250, 315, 2, d);
        d.setColor(new Color(243, 133, 8));
        d.fillCircle(650, 200, 45);
        drawStar(650, 180, 3, d);
        d.setColor(new Color(243, 133, 8));
        d.drawText(100, 100, "DRAGON BALL Z", 30);
    }

    /**
     * this method draws the background for level 4.
     *
     * @param d drawing surface
     */
    public static void drawLevel4(DrawSurface d) {
        d.setColor(new Color(7, 136, 204));
        d.fillRectangle(0, 0, 800, 600);
        //create raindrops
        for (int i = 0; i < 15; i++) {
            d.setColor(Color.WHITE);
            d.drawLine(75 + (i * 5), 410, 55 + (i * 5), 600);
        }
        //create raindrops
        for (int i = 0; i < 15; i++) {
            d.setColor(Color.WHITE);
            d.drawLine(505 + (i * 5), 410, 485 + (i * 5), 600);
        }
        //create clouds
        d.setColor(new Color(209, 220, 222));
        d.fillCircle(70, 400, 20);
        d.setColor(new Color(209, 220, 222));
        d.fillCircle(75, 425, 20);
        d.setColor(new Color(163, 174, 176));
        d.fillCircle(110, 400, 25);
        d.setColor(new Color(152, 160, 161));
        d.fillCircle(105, 430, 20);
        d.setColor(new Color(152, 160, 161));
        d.fillCircle(140, 420, 27);
        d.setColor(new Color(209, 220, 222));
        d.fillCircle(500, 400, 20);
        d.setColor(new Color(209, 220, 222));
        d.fillCircle(505, 425, 20);
        d.setColor(new Color(163, 174, 176));
        d.fillCircle(540, 400, 25);
        d.setColor(new Color(152, 160, 161));
        d.fillCircle(535, 430, 20);
        d.setColor(new Color(152, 160, 161));
        d.fillCircle(570, 420, 27);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //draw background for level 1
        if (this.levelInformation.levelName().equals("Direct Hit")) {
            drawLevel1(d);
        }
        //draw background for level 2
        if (this.levelInformation.levelName().equals("Neighbourhood Fun")) {
            drawLevel2(d);
        }
        //draw background for level 3
        if (this.levelInformation.levelName().equals("Dragon Ball Z")) {
            drawDragonBallZLevel(d);
        }
        //draw background for level 4
        if (this.levelInformation.levelName().equals("Rain Drops")) {
            drawLevel4(d);
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        d.setColor(Color.BLACK);
        d.drawText(550, 17, "Level Name: " + this.levelInformation.levelName(), 17);
        //if all the blocks were removed from the level end the level and add 100 point to the score
        if (0 < this.ballCount.getValue() && 0 >= this.blockCount.getValue()) {
            this.score.increase(100);
            this.running = false;
        }
        //if all the balls were removed from the level end the level
        if (0 >= this.ballCount.getValue()) {
            this.running = false;
        }
        //if the button 'p' is pressed pause the game
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, this.keyboard.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }

    }


    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * this method creates the balls on top of the paddle at the beginning of the level.
     */
    public void createBallsOnTopOfPaddle() {
        //create balls, add them to the game and count every ball created
        for (int i = 0; i < this.levelInformation.balls().size(); i++) {
            Ball ball = this.levelInformation.balls().get(i);
            this.ballCount.increase(1);
            //make the ball go directly to the block in level 1
            if (this.levelInformation.levelName().equals("Direct Hit")) {
                ball.setVelocity(0, 4);
            }
            ball.addToGame(this);
        }
    }

    /**
     * Run the game - start the animation loop.
     */
    public void run() {
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * checks if there are still balls in the game.
     *
     * @return true is the are balls and false otherwise
     */
    public boolean hasMoreBalls() {
        return this.ballCount.getValue() > 0;
    }

    /**
     * checks if there are still blocks in the game.
     *
     * @return true is the are blocks and false otherwise
     */
    public boolean hasMoreBlocks() {
        return this.blockCount.getValue() > 0;
    }

    /**
     * It draws a star.
     *
     * @param x    the x coordinate of the center of the star
     * @param y    The y coordinate of the center of the star.
     * @param size The size of the star.
     * @param d    The DrawSurface object that you will draw on.
     */
    public static void drawStar(int x, int y, int size, DrawSurface d) {
        y = y + 5;
        int[] xPnts = {x, x - 2 * size, x - 8 * size, x - 3 * size, x - 4 * size, x, x + 4 * size,
                x + 3 * size, x + 8 * size, x + 2 * size};
        int[] yPnts = {y - 2 * size, y + 3 * size, y + 3 * size, y + 6 * size, y + 12 * size,
                y + 8 * size, y + 12 * size, y + 6 * size, y + 3 * size, y + 3 * size};
        Polygon polygon = new Polygon(xPnts, yPnts, xPnts.length);
        d.setColor(new Color(183, 68, 0));
        d.fillPolygon(polygon);
        d.setColor(Color.BLACK);
        d.drawPolygon(polygon);
    }
}