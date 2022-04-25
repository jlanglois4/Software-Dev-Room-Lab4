package edu.wctc.roomimpl;

import edu.wctc.Exitable;
import edu.wctc.Player;
import edu.wctc.Room;

public class BasicRoom extends Room implements Exitable {
    public BasicRoom() {
        super("Boring Room");
    }

    @Override
    public String exit(Player player) {
        player.addToScore(100);
        player.quit();
        return "You can't get out of this boring room fast enough!";
    }

    @Override
    public String getDescription() {
        return "This room is totally nondescript. There is nothing to do or see here.";
    }
}
