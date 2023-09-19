// 208189126 Niv Swisa

/**
 * this class keeps count of the balls, blocks and score in the game.
 *
 * @author Niv Swisa
 */
public class Counter {
    private int count;

    /**
     * this is a counter constructor.
     *
     * @param number the number to added or subtracted
     */
    public Counter(int number) {
        this.count = number;
    }


    /**
     * this method adds a number to the current count.
     *
     * @param number the number to be added
     */
    public void increase(int number) {
        this.count += number;
    }


    /**
     * this method subtracts a number from the current count.
     *
     * @param number the number to be subtracted
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * get current count.
     *
     * @return current count
     */
    public int getValue() {
        return count;
    }
}