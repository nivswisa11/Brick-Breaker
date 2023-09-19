// 208189126 Niv Swisa

import java.awt.Color;

/**
 * this class creates level 1.
 *
 * @author Niv Swisa
 */
public class Level1 extends LevelMaster {
    /**
     * this is the level 1 constructor.
     */
    public Level1() {
        super();
        super.numberOfBalls();
        super.setPaddleValues(7, 150);
        super.setLevelName("Direct Hit");
        super.addToBallsList(new Ball(400, 555, 5, Color.WHITE));
        super.addToBlockList(new Block(new Rectangle(new Point(385, 185), 30, 30), Color.RED));
    }
}
