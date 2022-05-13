package edu.wctc.roomimpl;

import edu.wctc.Maze;
import edu.wctc.Player;
import edu.wctc.Room;

public interface IRoomTypes {
    String doAction(Player player, char actionType);
}
