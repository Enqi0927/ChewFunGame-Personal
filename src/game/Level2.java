package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Second level of the game with more platforms, enemies, and collectible items.
 */
public class Level2 extends GameLevel {
    private Player player;
    private Recipe recipe;
    private LevelManager levelManager;

    public Level2(LevelManager levelManager) {
        this.levelManager = levelManager;

        player = new Player(this);
        player.setPosition(new Vec2(0, -8));
        player.addCollisionListener(new CollisionHandler(player));

        // Adjusted platform positions for easier jumping
        new Platform(this, new Vec2(0, -10), 20, 1);    // Ground
        new Platform(this, new Vec2(-3, -6), 5, 1);      // First jump (adjusted)
        new Platform(this, new Vec2(3, -3), 5, 1);       // Second jump (adjusted)
        new Platform(this, new Vec2(0, 1), 4, 1);        // Third jump (adjusted)
        new Platform(this, new Vec2(4, 3), 4, 1);        // Final jump (adjusted)

        // Add enemies
        new Enemy(this, "Peanut", "data/peanut.png", new Vec2(-8, -9), 1.5f);
        new Enemy(this, "Mouse", "data/mouse.png", new Vec2(3, -2.5f), -1.5f);

        // Add items
        new Item(this, "Energy Drink", "data/item.png", new Vec2(-4, -5.5f));
        new Item(this, "Beef Noodle", "data/beef_noodles.png", new Vec2(3, -1.5f));
        new Item(this, "Energy Drink", "data/item.png", new Vec2(-3, 2.0f));

        // Final Recipe
        recipe = new Recipe(this, new Vec2(0, 5.5f));
        recipe.addCollisionListener(new RecipePickup(levelManager)); // Add collision listener
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    protected void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
