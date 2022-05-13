package edu.wctc;

import edu.wctc.roomimpl.BasicRoom;
import edu.wctc.roomimpl.DarkRoom;
import edu.wctc.roomimpl.SimpleRoom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Create Room objects and link them together to
    // form a maze


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        MazeRooms mazeRooms = new MazeRooms();
        // Create a network of Rooms linked to the

        Maze maze = new Maze(mazeRooms.startingRoom);


        MenuInterface menuInterface = new MenuInterface(maze);

        // Loop while the player has not exited the maze
        while (!maze.isFinished()) {
            // Print information about the current room: name,
            // description, potential directions to move
            System.out.println(maze.getCurrentRoomName());

            System.out.println(maze.getCurrentRoomDescription());

            System.out.println(maze.getCurrentRoomPossibleDirections());

            System.out.print(">> ");

            // Accept a single character from the player
            char command;
            try {
                command = keyboard.nextLine().toLowerCase().charAt(0);
                menuInterface.DoSomething(command);

            } catch (StringIndexOutOfBoundsException ignored) {
            }
            System.out.println();
        }
        System.out.println("GAME OVER");
        System.out.println("Score: "+maze.getPlayerScore());
    }


}

