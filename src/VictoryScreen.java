package game;

import javax.swing.*;

/**
 * Simple victory screen to show when the player finishes the final level.
 */
public class VictoryScreen {

    /**
     * Displays a congratulations message in a popup dialog.
     */
    public static void show() {
        JOptionPane.showMessageDialog(null,
                "🎉 Congratulations! You have completed the game!",
                "Victory",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
