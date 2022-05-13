package edu.wctc;

import edu.wctc.roomimpl.IRoomTypes;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Maze{
    // The player object
    private Player player;

    // The room the player is currently in

    // Initialize the maze with its starting room
    public Maze(Room startingRoom) {
        this.player = new Player();
        player.setCurrentRoom(startingRoom);
    }

    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getDescription();
    }

    public String getCurrentRoomName() {
        return player.getCurrentRoom().getName().toUpperCase();
    }

    public String getCurrentRoomPossibleDirections() {
        return player.getCurrentRoom().getPossibleDirections();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public boolean isFinished() {
        return !player.isPlaying();
    }

    // Called when the player types a direction to move from the current room
    public String move(char direction) {
        if (player.getCurrentRoom().hasRoomInDirection(direction)) {
            player.addPreviousRoom(player.getCurrentRoom());
            String exitMessage = "You leave the " + player.getCurrentRoom().getName();
            player.setCurrentRoom(player.getCurrentRoom().getAdjoiningRoom(direction));
            return exitMessage;
        }

        return "You cannot move in that direction!";
    }

    // Called when the player types i,l,x,q,t
    public String doAction(char actionType) {
        return ((IRoomTypes) player.getCurrentRoom()).doAction(player, actionType);
    }
}
