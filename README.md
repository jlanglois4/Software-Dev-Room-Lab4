# Closing the Maze
Starter project for the Module 4 lab demonstrating the Open/Closed Principle.

This is a slimmed-down version of the Maze game from Java Programming 152-130.

In the game, the player must navigate their way through a text adventure maze
of Room objects. Rooms are connected to each other in the cardinal compass
directions (North, South, East, West), as well as Up and Down directions.

Rooms that implement the Lootable interface contain items that the player
can acquire. Rooms that implement Interactable allow the player to interact
with them in some way (like lighting a torch or jumping on a trampoline).
And the player can only leave the maze (and end the game) if they
find and exit an Exitable room.

The player issues single-letter commands at a console prompt:  
- n,s,e,w,u,d - Movement commands (north, south, east, west, up, down)
- v - Display the player's current inventory
- l - Try to loot the room
- i - Try to interact with the room
- x - Try to exit the maze

The game continues until the player tries to exit the maze (command 'x') while in a room that allows that action.

