package edu.wctc.roomimpl;

import edu.wctc.Player;
import edu.wctc.Room;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TeleportService {

    private Room newRoom;

    public TeleportService(Player player) {
        List<Room> previousRooms = player.getPreviousRooms();
        System.out.println("The room contains a teleport stone.\n" +
                "Would you like to teleport to a previously visited room?");
        System.out.print(">> ");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine().toLowerCase();


        if (Objects.equals(input, "y") || Objects.equals(input, "yes")){
            System.out.println("Which room?");

            for (Room room:previousRooms) {
                if (room != player.getCurrentRoom()){
                    System.out.println(room.getName());
                }
            }


            input = keyboard.nextLine();

            Room newRoom = null;
            boolean exists = false;
            for (Room room:previousRooms) {
                if (room.getName().equalsIgnoreCase(input)){
                    exists = true;
                    newRoom = room;
                    break;
                }
            }

            if (exists){
                this.newRoom = newRoom;
            }

        }

    }

    public Room getNewRoom(){
        return newRoom;
    }
}
