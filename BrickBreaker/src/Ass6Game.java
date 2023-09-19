// 208189126 Niv Swisa

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * this class runs the game.
 *
 * @author Niv Swisa
 */
public class Ass6Game {
    /**
     * main method that calls all the other methods and runs the game.
     *
     * @param args arguments received from user
     */
    public static void main(String[] args) {
        GUI gui = new GUI("brick breaker", 800, 600);
        //new list of integers that will be the order of levels played
        List<Integer> orderOfLevels = new ArrayList<>();
        //for every argument, if the argument is an integer from 1 to 4 add it to the list
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1") || args[i].equals("2") || args[i].equals("3") || args[i].equals("4")) {
                orderOfLevels.add(Integer.parseInt(args[i]));
            }
        }
        //starting new game
        GameFlow game = new GameFlow(new AnimationRunner(gui, 60), gui.getKeyboardSensor());
        //create a new list of levels
        ArrayList<LevelInformation> gameLevels = new ArrayList<>();
        //add levels to the level list so the every level that is added is a member in the list of integers.
        for (int i = 0; i < orderOfLevels.size(); i++) {
            if (orderOfLevels.get(i) == 1) {
                gameLevels.add(new Level1());
            }
            if (orderOfLevels.get(i) == 2) {
                gameLevels.add(new Level2());
            }
            if (orderOfLevels.get(i) == 3) {
                gameLevels.add(new Level3());
            }
            if (orderOfLevels.get(i) == 4) {
                gameLevels.add(new Level4());
            }
        }
        //if there are no proper arguments then play the levels in order from 1 to 4.
        if (orderOfLevels.size() == 0) {
            gameLevels.add(new Level1());
            gameLevels.add(new Level2());
            gameLevels.add(new Level3());
            gameLevels.add(new Level4());
        }
        //run the game with all the levels
        game.runLevels(gameLevels);
    }
}
