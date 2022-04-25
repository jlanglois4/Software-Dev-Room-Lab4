package edu.wctc.roomimpl;

import edu.wctc.Interactable;
import edu.wctc.Player;
import edu.wctc.Room;

public class DarkRoom extends Room implements Interactable {
    public DarkRoom() {
        super("Dark Room");
    }

    @Override
    public String getDescription() {
        return "This room is pitch dark. You are likely to be eaten by a grue.";
    }

    @Override
    public String interact(Player player)
    {
        player.addToScore(-5);
        return "Does stumbling around bumping into things count as interacting?";
    }
}
