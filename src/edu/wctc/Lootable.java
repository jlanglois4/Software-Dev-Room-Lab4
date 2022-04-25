package edu.wctc;

// Rooms that implement this interface contain items
// that may be looted by the player by typing 'l'
//
// The Room receives the player object so that it can call
// its addToInventory and addToScore methods if desired.
public interface Lootable {
    String loot(Player player);
}
