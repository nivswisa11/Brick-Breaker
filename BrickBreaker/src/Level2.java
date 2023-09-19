// 208189126 Niv Swisa

import java.awt.Color;

/**
 * this class creates level 2.
 *
 * @author Niv Swisa
 */
public class Level2 extends LevelMaster {
    /**
     * this is the level 2 constructor.
     */
    public Level2() {
        super();
        super.numberOfBalls();
        super.setPaddleValues(7, 500);
        super.setLevelName("Neighbourhood Fun");
        //colors for the blocks
        Color[] blockColor = {Color.CYAN, Color.CYAN, Color.PINK, Color.PINK, Color.BLUE, Color.BLUE, Color.GREEN,
                Color.GREEN, Color.GREEN, Color.YELLOW, Color.YELLOW, Color.ORANGE, Color.ORANGE, Color.RED, Color.RED};
        //create balls
        for (int i = 0; i < 10; i++) {
            super.addToBallsList(new Ball(160 + (i * 48), 555, 5, Color.BLACK));
        }
        //create blocks
        for (int i = 0; i < 15; i++) {
            super.addToBlockList(new Block(new Rectangle(new Point(20 + (i * 50.66), 250), 50.66,
                    20), blockColor[i]));
        }
    }
}