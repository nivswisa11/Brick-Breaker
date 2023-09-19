// 208189126 Niv Swisa

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count of the number of blocks
 * that remain.
 *
 * @author Niv Swisa
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * a block remover constructor.
     *
     * @param game            the game that the block is removed from
     * @param remainingBlocks the number of blocks remaining in the game
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * this method removes the block from the game and removes the listener from the block. it also updates the number
     * of blocks in the game.
     *
     * @param beingHit the block that is hit by the ball
     * @param hitter   the ball that is hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}