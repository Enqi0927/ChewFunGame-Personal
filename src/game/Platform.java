package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Represents a static platform in the game.
 */
public class Platform extends StaticBody {
    public Platform(World world, Vec2 position, float width, float height) {
        super(world, new BoxShape(width, height)); // Set platform shape
        setPosition(position); // Set platform position
        addImage(new BodyImage("data/platform.png", height * 2)); // Set platform image
    }
}
