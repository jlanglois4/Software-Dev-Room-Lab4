package edu.wctc;

// Rooms that implement this interface allow the player
// to interact with them in some way by typing 'i'
//
// The Room receives the player object so that it can call
// its addToInventory and addToScore methods if desired.
public interface Interactable {
    String interact(Player player);
}
