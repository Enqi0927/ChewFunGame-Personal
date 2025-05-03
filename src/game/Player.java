package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main player character, controlled by the keyboard.
 */
public class Player extends Walker implements KeyListener {
    private int lives;
    private static final float MOVE_SPEED = 5f;
    private static final float JUMP_SPEED = 12f; // Increased for easier jumping

    public Player(World world) {
        super(world);

        // Define the player shape
        Shape playerShape = new BoxShape(0.5f, 1.0f);
        new SolidFixture(this, playerShape);

        // Add player image
        addImage(new BodyImage("data/player.png", 2.0f));

        lives = 3;
    }

    public int getLives() {
        return lives;
    }

    public void decreaseLives() {
        lives--;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            this.setLinearVelocity(new Vec2(-MOVE_SPEED, getLinearVelocity().y));
        } else if (code == KeyEvent.VK_RIGHT) {
            this.setLinearVelocity(new Vec2(MOVE_SPEED, getLinearVelocity().y));
        } else if (code == KeyEvent.VK_SPACE) {
            if (Math.abs(getLinearVelocity().y) < 0.01f) {
                this.jump(JUMP_SPEED);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
            this.setLinearVelocity(new Vec2(0, getLinearVelocity().y));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed
    }
}
