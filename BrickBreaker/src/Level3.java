// 208189126 Niv Swisa

import java.awt.Color;

/**
 * this class creates level 3.
 *
 * @author Niv Swisa
 */
public class Level3 extends LevelMaster {
    /**
     * this is the level 3 constructor.
     */
    public Level3() {
        super();
        super.numberOfBalls();
        super.setPaddleValues(7, 150);
        super.setLevelName("Dragon Ball Z");
        //colors for the blocks
        Color[] blockColor = {Color.GRAY, Color.RED, Color.YELLOW, Color.CYAN, Color.WHITE};
        //create the balls
        for (int i = 0; i < 2; i++) {
            super.addToBallsList(new Ball(335 + (i * 70), 555, 5, Color.WHITE));
        }
        //create the blocks
        for (int i = 0; i < 5; i++) {
            int height = 150 + (i * 20);
            for (int j = i; j < 10; j++) {
                super.addToBlockList(new Block(new Rectangle(new Point(730 - ((j - i) * 50), height), 50,
                        20), blockColor[i]));
            }
        }
    }
}