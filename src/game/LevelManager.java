package game;

import city.cs.engine.World;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages all levels and tracks elapsed game time.
 */
public class LevelManager {
    private List<GameLevel> levels;
    private int currentLevelIndex;
    private GameView view;
    private JFrame frame;
    private long startTime;

    public LevelManager(GameView view, JFrame frame) {
        this.view = view;
        this.frame = frame;
        levels = new ArrayList<>();
        currentLevelIndex = 0;

        levels.add(new Level1(this));
        levels.add(new Level2(this));
        levels.add(new Level3(this));

        startTime = System.currentTimeMillis();
    }

    public void startGame() {
        loadLevel(currentLevelIndex);
    }

    public void loadLevel(int index) {
        if (index >= 0 && index < levels.size()) {
            currentLevelIndex = index;
            GameLevel level = levels.get(index);

            view.setWorld(level);
            view.setPlayer(level.getPlayer()); // Always set the player

            level.start();
        }
    }

    public void nextLevel() {
        if (currentLevelIndex < levels.size() - 1) {
            currentLevelIndex++;
            loadLevel(currentLevelIndex);
        } else {
            // All levels completed
            VictoryScreen.show(); // This triggers the victory popup
        }
    }


    public GameLevel getCurrentLevel() {
        return levels.get(currentLevelIndex);
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public int getElapsedTime() {
        return (int) ((System.currentTimeMillis() - startTime) / 1000);
    }
}
