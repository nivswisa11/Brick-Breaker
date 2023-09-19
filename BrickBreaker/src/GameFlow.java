// 208189126 Niv Swisa

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * this class is in charge of running the game and switching levels.
 *
 * @author Niv Swisa
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter score;

    /**
     * this is the game flow constructor.
     *
     * @param ar animation runner
     * @param ks keyboard sensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.score = new Counter(0);
    }

    /**
     * this method runs akk the levels.
     *
     * @param levels a list of all the levels in the game
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean successOrDefeat = true;
        //for every level in the game initialize it and check the balls and blocks
        for (LevelInformation levelInfo : levels) {
            //create a new level
            GameLevel level = new GameLevel(levelInfo, this.score, this.ar, this.ks);
            //initialize the level
            level.initialize();
            //if there are still balls and blocks in the game, keep running the level
            while (level.hasMoreBalls() && level.hasMoreBlocks()) {
                level.run();
            }
            //if there are no more balls change the player status to lose
            if (!level.hasMoreBalls()) {
                successOrDefeat = false;
                //show the losing end screen and when the space key is pressed close the game screen and end the game
                this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                        new EndScreen(this.ks, this.score, successOrDefeat)));
                this.ar.getGui().close();
            }
        }
        //if the game has been won present the winning end screen and press space to close the game screen
        if (successOrDefeat) {
            this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                    new EndScreen(this.ks, this.score, successOrDefeat)));
        }
        this.ar.getGui().close();
    }
}