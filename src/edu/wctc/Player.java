package edu.wctc;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private boolean playing = true;

    private int score = 0;

    private Room currentRoom;

    private List<String> inventory = new ArrayList<>();

    private List<Room> previousRooms = new ArrayList<>();


    public void addPreviousRoom(Room room){
        if (!previousRooms.contains(room)){
            previousRooms.add(room);
        }
    }

    public List<Room> getPreviousRooms(){
        return previousRooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }



    public void addToInventory(String item) {
        inventory.add(item);

//        for(Companion companion : companions)
//            companion.notifyPlayerGainedItem(item);
    }

    public void addToScore(int points) {
        score += points;

//        for(Companion companion : companions)
//            companion.notifyPlayerScoreChanged(points);
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Your pockets are empty!";
        }

        String inv = "You are carrying: ";
        inv += String.join(", " , inventory);

        return inv;
    }

    public int getScore() {
        return score;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void quit() {
        playing = false;
    }

//    public void register(Companion companion) {
//        companions.add(companion);
//    }

}
