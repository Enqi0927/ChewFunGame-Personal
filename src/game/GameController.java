package game;

import city.cs.engine.World;
import javax.swing.*;

/**
 * Controls the game logic, managing levels and user input.
 */
public class GameController {
    private LevelManager levelManager;
    private GameView view;
    private JFrame frame;

    public GameController() {
        frame = new JFrame("ChewFun Cooking Adventure");
        view = new GameView(new World(), 800, 600);
        levelManager = new LevelManager(view, frame);

        // Assign the player and level manager
        view.setPlayer(levelManager.getCurrentLevel().getPlayer());
        view.setLevelManager(levelManager);

        // Ensure GameView receives keyboard input
        view.setFocusable(true);
        view.requestFocusInWindow();
        view.addKeyListener(levelManager.getCurrentLevel().getPlayer());

        frame.add(view);
        frame.setFocusable(false); // Prevent JFrame from stealing keyboard focus
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        levelManager.startGame();
    }

    public static void main(String[] args) {
        new GameController();
    }
}
