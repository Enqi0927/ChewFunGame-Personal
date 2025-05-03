package game;

import city.cs.engine.World;

/**
 * Abstract base class for all game levels.
 * Provides a standard way to access the player character.
 */
public abstract class GameLevel extends World {

    public GameLevel() {
        super();
    }

    /**
     * Each level must return its player object.
     * This ensures consistent player management across levels.
     */
    public abstract Player getPlayer();
}
