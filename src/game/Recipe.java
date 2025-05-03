package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Recipe extends StaticBody {
    public Recipe(World world, Vec2 position) {
        super(world, new BoxShape(1, 1));
        addImage(new BodyImage("data/recipe.png", 2));
        setPosition(position);
    }
}


