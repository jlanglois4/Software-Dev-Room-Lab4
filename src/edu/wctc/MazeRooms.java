package edu.wctc;

import edu.wctc.Room;
import edu.wctc.roomimpl.BasicRoom;
import edu.wctc.roomimpl.DarkRoom;
import edu.wctc.roomimpl.SimpleRoom;

import java.util.ArrayList;
import java.util.List;

public class MazeRooms {
    Room startingRoom;
    Room anotherRoom;
    Room thirdRoom;
    Room finalRoom;
    List<Room> allRooms = new ArrayList<>();

    public MazeRooms(){
        startingRoom = new BasicRoom(1);
        anotherRoom = new DarkRoom(1);
        thirdRoom = new SimpleRoom(1);
        finalRoom = new BasicRoom(2);

        startingRoom.setNorth(anotherRoom);
        anotherRoom.setSouth(startingRoom);


        anotherRoom.setDown(thirdRoom);
        thirdRoom.setUp(anotherRoom);

        anotherRoom.setEast(finalRoom);
        finalRoom.setWest(anotherRoom);

        allRooms.add(startingRoom);
        allRooms.add(anotherRoom);
        allRooms.add(thirdRoom);
        allRooms.add(finalRoom);
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

}
