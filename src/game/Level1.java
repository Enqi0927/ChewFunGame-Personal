package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * First level of the game.
 */
public class Level1 extends GameLevel {
    private Player player;
    private Recipe recipe;
    private LevelManager levelManager;

    public Level1(LevelManager levelManager) {
        this.levelManager = levelManager;

        player = new Player(this);
        player.setPosition(new Vec2(0, -8));
        player.addCollisionListener(new CollisionHandler(player));

        // Platforms
        new Platform(this, new Vec2(0, -10), 20, 1);
        new Platform(this, new Vec2(-5, -5), 5, 1);
        new Platform(this, new Vec2(5, 0), 5, 1);

        // Enemies
        new Enemy(this, "Peanut", "data/peanut.png", new Vec2(-6, -9), 1.5f);

        // Items
        new Item(this, "Energy Drink", "data/item.png", new Vec2(-5, -4));

        // Final Recipe
        recipe = new Recipe(this, new Vec2(5, 1));
        recipe.addCollisionListener(new RecipePickup(levelManager)); // ★ Add listener
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
