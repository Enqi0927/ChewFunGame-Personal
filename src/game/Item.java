package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Represents a collectible item in the game.
 */
public class Item extends StaticBody {
    private String itemType;  // Stores the type of item

    public Item(World world, String itemType, String imagePath, Vec2 position) {
        super(world, new BoxShape(1, 1));  // Define the item's shape
        this.itemType = itemType;
        addImage(new BodyImage(imagePath, 2));  // Set the item's image
        setPosition(position);
    }

    /**
     * Get the type of this item.
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Handle the item being collected by the player.
     */
    public void collect() {
        this.destroy();  // Remove the item from the world
    }
}

