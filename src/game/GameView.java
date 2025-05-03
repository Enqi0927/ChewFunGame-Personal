package game;

import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Main view class that renders the game world and updates player information.
 */
public class GameView extends UserView {
    private Player player;
    private LevelManager levelManager;
    private final Image background;
    private final JLabel statusLabel;

    public GameView(World world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.png").getImage();

        // Setting up UI label
        statusLabel = new JLabel("Lives: 3 | Time: 0");
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(statusLabel);

        this.setFocusable(true);
        SwingUtilities.invokeLater(() -> requestFocusInWindow());

        // Timer to update lives and time every second
        Timer timer = new Timer(1000, e -> updateStatus());
        timer.start();
    }

    /**
     * Set the current player and attach keyboard and mouse controls.
     */
    public void setPlayer(Player player) {
        this.player = player;
        this.addKeyListener(player);

    }

    /**
     * Set the current level manager.
     */
    public void setLevelManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    /**
     * Draw background image.
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    /**
     * Update the UI label to show player's current lives and elapsed time.
     */
    public void updateStatus() {
        if (player != null && levelManager != null) {
            statusLabel.setText("Lives: " + player.getLives() + " | Time: " + levelManager.getElapsedTime());
        }
    }
}
