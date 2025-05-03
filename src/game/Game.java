package game;

import city.cs.engine.*;

import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.*;


/**
 * Your main game entry point
 */
public class Game {
    private LevelManager levelManager; // Manages game levels
    private GameView view;            // Game view (rendering)
    private JFrame frame;             // Game window



    /** Initialise a new Game. */
    public Game() {
        // Initialize game window
        frame = new JFrame("ChewFun Cooking Adventure");
        view = new GameView(new World(), 800, 600);
        levelManager = new LevelManager(view, frame);

        // Assign the player and level manager
        view.setPlayer(levelManager.getCurrentLevel().getPlayer());
        view.setLevelManager(levelManager);

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);

        //Ensure GameView receives keyboard input
        view.addKeyListener(levelManager.getCurrentLevel().getPlayer());
        view.setFocusable(true);
        view.requestFocusInWindow();



        // Configure window
        frame.add(view);
        frame.setFocusable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        levelManager.startGame();
    }






    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
