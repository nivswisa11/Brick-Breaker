// 208189126 Niv Swisa

/**
 * a BallRemover is in charge of removing balls from the game, as well as keeping count of the number of balls
 * that remain.
 *
 * @author Niv Swisa
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * a ball remover constructor.
     *
     * @param game           the game that the ball is removed from
     * @param remainingBalls the number of balls that are still in the game
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * this method removes the ball from the game and updates the number of balls in the game.
     *
     * @param beingHit the block that is hit by the ball
     * @param hitter   the ball that is hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
    }
}