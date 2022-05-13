package edu.wctc;

public class MenuInterface {

    private Maze maze;

    public MenuInterface(Maze maze) {
        this.maze = maze;
    }


    public void DoSomething(char command) {
        String output;
        switch (command) {
            case 'n':
            case 's':
            case 'e':
            case 'w':
            case 'u':
            case 'd':
                // Move in one of the available directions
                output = maze.move(command);
                break;
            case 'v':
                // Display the player's inventory
                output = maze.getPlayerInventory();
                break;
            case 'i':
                output = maze.doAction(command);
                if (output.isBlank()) {
                    output = "There is nothing to interact with.";
                }
                break;
            case 'l':
                output = maze.doAction(command);
                if (output.isBlank()) {
                    output = "There is nothing to loot.";
                }
                break;
            case 'x':
                output = maze.doAction(command);
                if (output.isBlank()) {
                    output = "There is no exit.";
                }
                break;
            case 'q':
                output = maze.doAction(command);
                if (output.isBlank()) {
                    output = "There is nothing to destroy.";
                }
                break;
            case 't':
                // Try to destroy the maze from the current room
                // Try to exit the maze from the current room
                // Try to loot the current room
                // Try to interact with the current room


                output = maze.doAction(command);
                if (output.isBlank()) {
                    output = "There is no teleport stone in the room.";
                }
                break;
            default:
                // ?? Unknown
                output = "Unknown command";
                break;
        }
        System.out.println(output);
    }
}
