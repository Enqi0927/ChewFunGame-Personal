
package game;
import org.jbox2d.common.Vec2;
import city.cs.engine.*;

/**
 * Final level of the game with new layout and tougher enemies.
 */
public class Level3 extends GameLevel {  // Ensure it inherits from GameLevel
    private Player player;
    private Recipe recipe;
    private LevelManager levelManager;

    public Level3(LevelManager levelManager) {
        this.levelManager = levelManager;

        player = new Player(this);
        player.setPosition(new Vec2(0, -8));
        player.addCollisionListener(new CollisionHandler(player));

        // New platform layout
        new Platform(this, new Vec2(0, -10), 20, 1);    // Ground
        new Platform(this, new Vec2(-5, -5), 5, 1);     // First jump
        new Platform(this, new Vec2(5, 0), 5, 1);       // Second jump
        new Platform(this, new Vec2(0, 5), 4, 1);       // Third jump

        // Add tougher enemies
        new Enemy(this, "Blender", "data/blender.png", new Vec2(-3, -4), 1.2f);
        new Enemy(this, "Microwave", "data/microwave.png", new Vec2(3, 1), -1.4f);

        // Add healing items
        new Item(this, "Beef Noodle", "data/beef_noodles.png", new Vec2(-2, 2));
        new Item(this, "Energy Drink", "data/item.png", new Vec2(2, 6));

        // Set the final Recipe
        recipe = new Recipe(this, new Vec2(0, 7));
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
