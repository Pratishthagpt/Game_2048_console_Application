package org.example.model;

public class GameBoard {
    private int board_size;
    private Tile [][] grid;

    public GameBoard() {
        this.board_size = 4;
        grid = new Tile[board_size][board_size];

        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(i);
                grid[i][j].setY(j);
                grid[i][j].setTileNum("_");
            }
        }
    }

    public int getBoard_size() {
        return board_size;
    }

    public void setBoard_size(int board_size) {
        this.board_size = board_size;
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }
}
