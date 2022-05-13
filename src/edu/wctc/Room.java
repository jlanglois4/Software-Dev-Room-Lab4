package edu.wctc;

import edu.wctc.roomimpl.IRoomTypes;

public abstract class Room {
    private String name;
    // Connections to other rooms.
    // If a Room variable is null, there is no connection in
    // that direction and the player may not move that way.
    private Room north, south, east, west, up, down;

    public Room(String name) {
        this.name = name;
    }
    // Returns the Room connected to this Room in the given
    // direction, or null if in invalid direction is supplied.
    public Room getAdjoiningRoom(char direction) {
        if (direction == 'n')
            return north;
        if (direction == 's')
            return south;
        if (direction == 'e')
            return east;
        if (direction == 'w')
            return west;
        if (direction == 'u')
            return up;
        if (direction == 'd')
            return down;

        return null;
    }

    public abstract String getDescription();

    // Returns a String that will be displayed to the
    // player indiciating which directions he can move
    // from this room.
    public String getPossibleDirections() {
        String exits = "The exits are: ";
        if (north != null)
            exits += "North ";
        if (south != null)
            exits += "South ";
        if (east != null)
            exits += "East ";
        if (west != null)
            exits += "West ";
        if (up != null)
            exits += "Up ";
        if (down != null)
            exits += "Down ";

        return exits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Returns true if this Room has another Room
    // connected to it in the given direction, false
    // otherwise.
    public boolean hasRoomInDirection(char direction) {
        if (direction == 'n')
            return north != null;
        if (direction == 's')
            return south != null;
        if (direction == 'e')
            return east != null;
        if (direction == 'w')
            return west != null;
        if (direction == 'u')
            return up != null;
        if (direction == 'd')
            return down != null;

        return false;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}