package org.example.model;

public class Game {
    private GameBoard gameBoard;
    private int score;
    private int best;


    public Game() {
        this.gameBoard = new GameBoard();
        this.score = 0;
        this.best = 0;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBest() {
        return best;
    }

    public void setBest(int best) {
        this.best = best;
    }

    public void initializeGame() {
        Tile [][] grid = new Tile[gameBoard.getBoard_size()][gameBoard.getBoard_size()];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(i);
                grid[i][j].setY(i);
                grid[i][j].setTileNum("_");

            }
        }
        gameBoard.setGrid(grid);
        setGameBoard(gameBoard);
        setScore(0);
        setBest(0);
    }



    public void displayBoard(GameBoard gameBoard) {
        Tile [][] grid = new Tile[gameBoard.getBoard_size()][gameBoard.getBoard_size()];
        grid = gameBoard.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j].getTileNum() + " ");
            }
            System.out.println();
        }
    }



}
