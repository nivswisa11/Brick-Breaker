// 208189126 Niv Swisa

import java.awt.Color;

/**
 * this class creates level 4.
 *
 * @author Niv Swisa
 */
public class Level4 extends LevelMaster {
    /**
     * this is the level 4 constructor.
     */
    public Level4() {
        super();
        super.numberOfBalls();
        super.setPaddleValues(7, 150);
        super.setLevelName("Rain Drops");
        //colors for the blocks
        Color[] blockColor = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};
        //create balls
        for (int i = 0; i < 3; i++) {
            super.addToBallsList(new Ball(335 + (i * 43), 555, 5, Color.WHITE));
        }
        //create blocks
        for (int i = 0; i < 7; i++) {
            int height = 230 - (i * 20);
            for (int j = 0; j < 15; j++) {
                super.addToBlockList(new Block(new Rectangle(new Point(20 + (j * 50.66), height), 50.66,
                        20), blockColor[i]));
            }
        }
    }
}