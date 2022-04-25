package edu.wctc;

// Rooms that implement this interface may be used to exit
// the maze (thus ending the game) by typing 'x' while in them.
//
// The Room receives the player object so that it can call
// its addToInventory and addToScore methods if desired.
public interface Exitable {
    String exit(Player player);
}
