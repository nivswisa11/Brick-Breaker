// 208189126 Niv Swisa

/**
 * this Interface is in charge of adding hit notifiers the the HitListener list.
 *
 * @author Niv Swisa
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl hit listener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl hit listener
     */
    void removeHitListener(HitListener hl);
}