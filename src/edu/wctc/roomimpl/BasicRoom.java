package edu.wctc.roomimpl;

import edu.wctc.*;

public class BasicRoom extends Room implements IRoomTypes {
    private boolean hasDestroyed = false;
    private boolean hasLooted = false;

    public BasicRoom(int number) {
        super("Boring Room " + number);
    }
    @Override
    public String doAction(Player player, char actionType) {
        String actionString = "";
        switch (actionType) {
            case 'l' -> actionString = loot(player);
            case 'x' -> actionString = exit(player);
            case 'q' -> actionString = destroy(player);
        }
        return actionString;
    }

    private String destroy(Player player) {
        if (!hasDestroyed){
            player.addToScore(50);
            hasDestroyed = true;
            return "You destroy a cube.";
        } else {
            return "There is nothing else to destroy.";
        }
    }

    private String exit(Player player) {
        player.addToScore(100);
        player.quit();
        return "You can't get out of this boring room fast enough!";
    }

    private String loot(Player player) {
        if (!hasLooted){
            player.addToInventory("Painting");
            hasLooted = true;
            return "You pick up a basic painting.";
        } else {
            return "There is nothing else to loot.";
        }
    }

    public String getDescription() {
        return "This room is totally nondescript. There is nothing to do or see here.";
    }
}

