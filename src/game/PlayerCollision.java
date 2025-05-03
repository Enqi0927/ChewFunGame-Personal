package game;

import city.cs.engine.*;

/**
 * Handles collision events involving the player.
 */
public class PlayerCollision implements CollisionListener {
    private Player player;
    private LevelManager levelManager;

    public PlayerCollision(Player player, LevelManager levelManager) {
        this.player = player;
        this.levelManager = levelManager;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy) {
            // Player gets hit by an enemy
            player.decreaseLives();
            System.out.println("Player hit! Lives left: " + player.getLives());

            if (player.getLives() <= 0) {
                System.out.println("Game Over");
                // You could add game over logic here if needed
            }
        } else if (e.getOtherBody() instanceof Item) {
            // Player collects an item
            Item item = (Item) e.getOtherBody();
            item.collect();
        } else if (e.getOtherBody() instanceof Recipe) {
            // Player reaches the recipe goal
            System.out.println("Recipe collected! Moving to next level...");
            levelManager.nextLevel();
        }
    }
}
