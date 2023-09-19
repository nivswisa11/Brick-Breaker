// 208189126 Niv Swisa

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * this class creates a sprite collection.
 *
 * @author Niv Swisa
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * sprite constructor. creates a new sprite list.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * this method adds a sprite to the sprite list.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    /**
     * this method removes a sprite from the sprite list.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        spriteList.remove(s);
    }

    /**
     * this method calls timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        //calling timePassed method on all sprites
        for (int i = 0; i < spriteList.size(); i++) {
            spriteList.get(i).timePassed();
        }
    }

    /**
     * this method calls drawOn on all sprites.
     *
     * @param d drawing surface
     */
    public void drawAllOn(DrawSurface d) {
        //calling drawOn on all sprites
        for (int i = 0; i < spriteList.size(); i++) {
            spriteList.get(i).drawOn(d);
        }
    }
}