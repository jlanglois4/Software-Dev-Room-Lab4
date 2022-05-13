package edu.wctc.roomimpl;

import edu.wctc.Player;
import edu.wctc.Room;

public class DarkRoom extends Room implements IRoomTypes {
    

    public DarkRoom(int number) {
        super("Dark Room " + number);
    }

    @Override
    public String doAction(Player player, char actionType) {
        String actionString = "";
        switch (actionType) {
            case 'i' -> actionString = interact(player);
            case 't' -> actionString = teleport(player);
        }
        return actionString;
    }

    public String getDescription() {
        return "This room is pitch dark. You are likely to be eaten by a grue.";
    }


    private String interact(Player player) {
        player.addToScore(-5);
        return "Does stumbling around bumping into things count as interacting?";
    }

    private String teleport(Player player) {
        TeleportService teleportService = new TeleportService(player);
        Room newRoom = teleportService.getNewRoom();
           if (newRoom != null){
               player.setCurrentRoom(newRoom);
               return "You teleport to " + newRoom.getName() + ".";
           }
           return "Nothing happens.";
    }
}
