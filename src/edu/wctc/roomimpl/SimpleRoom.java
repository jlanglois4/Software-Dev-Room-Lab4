package edu.wctc.roomimpl;

import edu.wctc.Maze;
import edu.wctc.Player;
import edu.wctc.Room;

public class SimpleRoom extends Room implements IRoomTypes {

    private boolean hasLooted = false;

    public SimpleRoom(int number) {
        super("Simple Room " + number);
    }

    @Override
    public String doAction(Player player, char actionType) {
        String actionString = "";
        switch (actionType) {
            case 'l' -> actionString = loot(player);
        }
        return actionString;
    }
    public String getDescription() {
        return "'Minimalist' would be a nice way of describing this room.";
    }

    private String loot(Player player) {
        if (!hasLooted){
            player.addToInventory("Wooden scraps");
            hasLooted = true;
            return "Wow, there were some amazing treasures hidden here... at one time.";
        } else {
            return "There is nothing to loot.";
        }
    }

}
