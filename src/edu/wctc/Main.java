package edu.wctc;

import edu.wctc.roomimpl.BasicRoom;
import edu.wctc.roomimpl.DarkRoom;
import edu.wctc.roomimpl.SimpleRoom;

import java.util.Scanner;

public class Main {

    // Create Room objects and link them together to
    // form a maze
    private static Room createRooms() {
        Room startingRoom = new BasicRoom();

        Room anotherRoom = new DarkRoom();
        startingRoom.setNorth(anotherRoom);
        anotherRoom.setSouth(startingRoom);

        Room thirdRoom = new SimpleRoom();
        anotherRoom.setDown(thirdRoom);
        thirdRoom.setUp(anotherRoom);

        Room finalRoom = new BasicRoom();
        anotherRoom.setEast(finalRoom);
        finalRoom.setWest(anotherRoom);

        // Return the starting room
        return startingRoom;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Create a network of Rooms linked to the
        // starting room
        Room startingRoom = createRooms();

        // Pass the starting room to the Maze object
        Maze maze = new Maze(startingRoom);

        // Loop while the player has not exited the maze
        while (!maze.isFinished()) {
            // Print information about the current room: name,
            // description, potential directions to move
            System.out.println(maze.getCurrentRoomName());

            System.out.println(maze.getCurrentRoomDescription());

            System.out.println(maze.getCurrentRoomPossibleDirections());

            System.out.print(">> ");

            // Accept a single character from the player
            char command = keyboard.nextLine().toLowerCase().charAt(0);

            switch (command) {
                case 'n':
                case 's':
                case 'e':
                case 'w':
                case 'u':
                case 'd':
                    // Move in one of the available directions
                    System.out.println(maze.move(command));
                    break;
                case 'v':
                    // Display the player's inventory
                    System.out.println(maze.getPlayerInventory());
                    break;
                case 'i':
                    // Try to interact with the current room
                    System.out.println(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    // Try to loot the current room
                    System.out.println(maze.lootCurrentRoom());
                    break;
                case 'x':
                    // Try to exit the maze from the current room
                    System.out.println(maze.exitCurrentRoom());
                    break;
                 default:
                    // ?? Unknown
                    System.out.println("Unknown command");
                    break;
            }

            System.out.println();
        }

        System.out.println("GAME OVER");
        System.out.println("Score: " + maze.getPlayerScore());
    }

}
