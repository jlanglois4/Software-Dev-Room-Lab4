package edu.wctc;

public class Maze {
    // The player object
    private Player player;

    // The room the player is currently in
    private Room currentRoom;


    // Initialize the maze with its starting room
    public Maze(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.player = new Player();
    }

    // Called when the player types 'x' to try to exit the maze
    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            return ((Exitable) currentRoom).exit(player);
        }

        return "There is no exit here!";
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName().toUpperCase();
    }

    public String getCurrentRoomPossibleDirections() {
        return currentRoom.getPossibleDirections();
    }

    // Called when the player types 'i' to try to interact with current room
    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            return ((Interactable) currentRoom).interact(player);
        }

        return "There's nothing to interact with here!";
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

    // Called when the player types 'l' to try to loot current room
    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            return ((Lootable) currentRoom).loot(player);
        }

        return "There's nothing to loot here!";
    }

    // Called when the player types a direction to move from the current room
    public String move(char direction) {
        if (currentRoom.hasRoomInDirection(direction)) {
            String exitMessage = "You leave the " + currentRoom.getName();
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return exitMessage;
        }

        return "You cannot move in that direction!";
    }
}
