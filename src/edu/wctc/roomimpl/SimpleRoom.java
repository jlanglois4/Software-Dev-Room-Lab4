package edu.wctc.roomimpl;

import edu.wctc.Lootable;
import edu.wctc.Player;
import edu.wctc.Room;

public class SimpleRoom extends Room implements Lootable {
    public SimpleRoom() {
        super("Simple Room");
    }

    @Override
    public String getDescription() {
        return "'Minimalist' would be a nice way of describing this room.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Wooden scraps");
        return "Wow, there were some amazing treasures hidden here... at one time.";
    }
}
