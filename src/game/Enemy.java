package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Enemy class with simple AI movement.
 */
public class Enemy extends Walker implements StepListener {
    private float speed;
    private float leftBound, rightBound;
    private boolean movingRight = true;

    public Enemy(World world, String enemyType, String imagePath, Vec2 startPos, float speed) {
        super(world, new BoxShape(1, 1));
        addImage(new BodyImage(imagePath, 2));
        setPosition(startPos);
        this.speed = speed;
        this.leftBound = startPos.x - 5; // Moves within a range
        this.rightBound = startPos.x + 5;

        // Register StepListener to allow movement updates
        world.addStepListener(this);
    }

    @Override
    public void preStep(StepEvent e) {
        if (movingRight) {
            setPosition(new Vec2(getPosition().x + speed, getPosition().y));
            if (getPosition().x > rightBound) {
                movingRight = false;
            }
        } else {
            setPosition(new Vec2(getPosition().x - speed, getPosition().y));
            if (getPosition().x < leftBound) {
                movingRight = true;
            }
        }
    }

    @Override
    public void postStep(StepEvent e) {
        // No post-step actions needed for now
    }
}
