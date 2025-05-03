package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Detects when the player collects the recipe and progresses to the next level.
 */
public class RecipePickup implements CollisionListener {
    private LevelManager levelManager;
    private boolean collected = false; // Prevent multiple triggers

    public RecipePickup(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (!collected && e.getReportingBody() instanceof Recipe && e.getOtherBody() instanceof Player) {
            collected = true; // Set to true immediately
            System.out.println("Recipe collected! Moving to next level...");
            levelManager.nextLevel(); // Go to the next level (trigger victory screen if it's the last level)
        }
    }
}
