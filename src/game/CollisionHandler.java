package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CollisionHandler implements CollisionListener {
    private Player player;

    public CollisionHandler(Player player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy) {
            player.decreaseLives();
            System.out.println("Player hit an enemy! Lives left: " + player.getLives());
        }
        else if (e.getOtherBody() instanceof Item) {
            Item item = (Item) e.getOtherBody();

            //  Make sure we're calling getItemType() instead of getType()
            if (item.getItemType().contains("Noodle")) {
                System.out.println("You ate " + item.getItemType() + " and restored health!");
            }

            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Recipe) {
            System.out.println("You found the recipe! You win!");
        }
    }
}

