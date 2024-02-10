# Requirements from work@tech -
1. Create a command-line application for the above game with the following requirements:
2. Initialize the game with two tiles numbered 2 at random positions.
3. Print the board after initializing.
4. Allow the user to make moves.
5. The user will make a move by entering a number.
    0 denotes left
    1 denotes right
    2 denotes top
    3 denotes bottom
6. Slide the tiles based on the value, if the slide is possible.
7. Add a random tile on the board
8. Print the board after the move
9. End the game if it is won or lost
10. Print "Congratulations" if the game is won
11. Print "Game over" if the game is lost

# Rules of the game
1. All the tiles on the board will be a power of 2 like 2, 4, 8, 16, 32, 64, 128,...., 2048.
2. There are 4 possible moves: left, right, top, bottom.
3. On each move, all the tiles slide in the direction of the move until they are stopped by another tile or an edge.
4. A random tile will be inserted at a random empty spot on the board after every move.
5. If after sliding, two tiles with the same values collide in the direction of the slide then they will merge into a tile with the value being the total of the collided tiles.
    Example: Two tiles numbered 4 will merge to form a tile numbered 8. The merging will happen in the direction of the movement.
6. A merged tile will not merge with another tile in the same move.
7. In case 3 consecutive tiles have the same number then the farther tile in the direction of the move will merge. In case all four tiles have the same number then the first two and last two will merge.
8. The game is won if the board has a tile numbered 2048.
9. The game is lost if there are no possible moves left: No empty tile and no adjacent tiles with the same number.
