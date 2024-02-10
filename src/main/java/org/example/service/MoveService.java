package org.example.service;

import org.example.model.Game;
import org.example.model.GameBoard;
import org.example.model.Tile;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MoveService {

    private Random random = new Random();
    public Game moveLeft(Game game) {
        boolean isTileMoved = false;
        GameBoard board = game.getGameBoard();
        Tile [][] grid = new Tile[board.getBoard_size()][board.getBoard_size()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(board.getGrid()[i][j].getX());
                grid[i][j].setY(board.getGrid()[i][j].getY());
                grid[i][j].setTileNum(board.getGrid()[i][j].getTileNum());
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for(int j = 1; j < grid[i].length; j++) {
//            mergeValue keeps track of the last merge tile and make sure that it should not merge with another tile in same move
                int mergeTile = -1;
                if (!grid[i][j].getTileNum().equals("_")) {
                    int col = j;
                    while (col > 0 && (grid[i][col-1].getTileNum().equals("_")
                            || grid[i][col - 1].getTileNum().equals(grid[i][col].getTileNum()))) {
                        if (grid[i][col - 1].getTileNum().equals(grid[i][col].getTileNum())  && mergeTile != col - 1) {
                            int newTileNum = Integer.parseInt(grid[i][col - 1].getTileNum()) * 2;
                            grid[i][col - 1].setTileNum(String.valueOf(newTileNum));
                            grid[i][col].setTileNum("_");
                            game.setScore(game.getScore() + newTileNum);
                            mergeTile = col - 1;
                            isTileMoved = true;
                        }
                        else if (grid[i][col-1].getTileNum().equals("_")) {
                            int newTileNum = Integer.parseInt(grid[i][col].getTileNum());
                            grid[i][col - 1].setTileNum(String.valueOf(newTileNum));
                            grid[i][col].setTileNum("_");
                            isTileMoved = true;
                        }
                        col--;
                    }
                }
            }
        }
        board.setGrid(grid);
        board.setBoard_size(grid.length);
        game.setGameBoard(board);
        if(isTileMoved) {
            game = addNewTile(game);
            game = updateScore(game);
        }
        return game;
    }

    public Game moveRight(Game game) {
        boolean isTileMoved = false;
        GameBoard board = game.getGameBoard();
        Tile [][] grid = new Tile[board.getBoard_size()][board.getBoard_size()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(board.getGrid()[i][j].getX());
                grid[i][j].setY(board.getGrid()[i][j].getY());
                grid[i][j].setTileNum(board.getGrid()[i][j].getTileNum());
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for(int j = grid[i].length - 2; j >= 0; j--) {
                int mergeTile = -1;
                if (!grid[i][j].getTileNum().equals("_")) {
                    int col = j;
                    while (col < grid[i].length - 1 && (grid[i][col+1].getTileNum().equals("_")
                            || grid[i][col + 1].getTileNum().equals(grid[i][col].getTileNum()))) {
                        if (grid[i][col + 1].getTileNum().equals(grid[i][col].getTileNum()) && mergeTile != col + 1) {
                            int newTileNum = Integer.parseInt(grid[i][col + 1].getTileNum()) * 2;
                            grid[i][col + 1].setTileNum(String.valueOf(newTileNum));
                            grid[i][col].setTileNum("_");
                            game.setScore(game.getScore() + newTileNum);
                            mergeTile = col + 1;
                            isTileMoved = true;
                        }
                        else if (grid[i][col+1].getTileNum().equals("_")) {
                            int newTileNum = Integer.parseInt(grid[i][col].getTileNum());
                            grid[i][col + 1].setTileNum(String.valueOf(newTileNum));
                            grid[i][col].setTileNum("_");
                            isTileMoved = true;
                        }
                        col++;
                    }
                }
            }
        }
        board.setGrid(grid);
        board.setBoard_size(grid.length);
        game.setGameBoard(board);
        if(isTileMoved) {
            game = addNewTile(game);
            game = updateScore(game);
        }
        return game;
    }

    public Game moveTop(Game game) {
        boolean isTileMoved = false;
        GameBoard board = game.getGameBoard();
        Tile [][] grid = new Tile[board.getBoard_size()][board.getBoard_size()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(board.getGrid()[i][j].getX());
                grid[i][j].setY(board.getGrid()[i][j].getY());
                grid[i][j].setTileNum(board.getGrid()[i][j].getTileNum());
            }
        }

        for (int j = 0; j < grid.length; j++) {
            for(int i = 1; i < grid[j].length; i++) {
                int mergeTile = -1;
                if (!grid[i][j].getTileNum().equals("_")) {
                    int row = i;
                    while (row > 0 && (grid[row-1][j].getTileNum().equals("_")
                            || grid[row-1][j].getTileNum().equals(grid[row][j].getTileNum()))) {
                        if (grid[row-1][j].getTileNum().equals(grid[row][j].getTileNum())  && mergeTile != row - 1) {
                            int newTileNum = Integer.parseInt(grid[row-1][j].getTileNum()) * 2;
                            grid[row-1][j].setTileNum(String.valueOf(newTileNum));
                            grid[row][j].setTileNum("_");
                            game.setScore(game.getScore() + newTileNum);
                            mergeTile = row - 1;
                            isTileMoved = true;
                        }
                        else if (grid[row-1][j].getTileNum().equals("_")) {
                            int newTileNum = Integer.parseInt(grid[row][j].getTileNum());
                            grid[row-1][j].setTileNum(String.valueOf(newTileNum));
                            grid[row][j].setTileNum("_");
                            isTileMoved = true;
                        }
                        row--;
                    }
                }
            }
        }
        board.setGrid(grid);
        board.setBoard_size(grid.length);
        game.setGameBoard(board);
        if(isTileMoved) {
            game = addNewTile(game);
            game = updateScore(game);
        }
        return game;
    }

    public Game moveBottom(Game game) {
        boolean isTileMoved = false;
        GameBoard board = game.getGameBoard();
        Tile [][] grid = new Tile[board.getBoard_size()][board.getBoard_size()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(board.getGrid()[i][j].getX());
                grid[i][j].setY(board.getGrid()[i][j].getY());
                grid[i][j].setTileNum(board.getGrid()[i][j].getTileNum());
            }
        }

        for (int j = 0; j < grid.length; j++) {
            for(int i = grid[j].length - 2; i >= 0; i--) {
                int mergeTile = -1;
                if (!grid[i][j].getTileNum().equals("_")) {
                    int row = i;
                    while (row < grid.length - 1 && (grid[row+1][j].getTileNum().equals("_")
                            || grid[row+1][j].getTileNum().equals(grid[row][j].getTileNum()))) {
                        if (grid[row+1][j].getTileNum().equals(grid[row][j].getTileNum())  && mergeTile != row + 1) {
                            int newTileNum = Integer.parseInt(grid[row+1][j].getTileNum()) * 2;
                            grid[row+1][j].setTileNum(String.valueOf(newTileNum));
                            grid[row][j].setTileNum("_");
                            game.setScore(game.getScore() + newTileNum);
                            mergeTile = row + 1;
                            isTileMoved = true;
                        }
                        else if (grid[row+1][j].getTileNum().equals("_")) {
                            int newTileNum = Integer.parseInt(grid[row][j].getTileNum());
                            grid[row+1][j].setTileNum(String.valueOf(newTileNum));
                            grid[row][j].setTileNum("_");
                            isTileMoved = true;
                        }
                        row++;
                    }
                }
            }
        }
        board.setGrid(grid);
        board.setBoard_size(grid.length);
        game.setGameBoard(board);
        if(isTileMoved) {
            game = addNewTile(game);
            game = updateScore(game);
        }
        return game;
    }

    public Game addNewTile(Game game) {
        int row = 0, col = 0;
        GameBoard board = game.getGameBoard();
        int boardSize = board.getBoard_size();
        Tile [][] grid = new Tile[boardSize][boardSize];
        grid = game.getGameBoard().getGrid();
        Tile [][] copyGrid = new Tile[grid.length][grid.length];

        copyGrid = copyToNewArray(copyGrid, grid);

        while (!copyGrid[row][col].getTileNum().equals("_")) {
            row = random.nextInt(game.getGameBoard().getBoard_size());
            col = random.nextInt(game.getGameBoard().getBoard_size());
        }

        copyGrid[row][col].setTileNum("2");
        board.setGrid(copyGrid);
        board.setBoard_size(copyGrid.length);
        game.setGameBoard(board);
        return game;
    }

    public Game updateScore(Game game) {
        if (game.getBest() < game.getScore()) {
            game.setBest(game.getScore());
        }
        return game;
    }

    public Tile [][]  copyToNewArray (Tile [][] newArr, Tile [][] oldArr) {
        for (int i = 0; i < oldArr.length; i++) {
            for(int j = 0; j < oldArr[i].length; j++) {
                newArr[i][j] = new Tile(i, j, "");
                newArr[i][j].setX(oldArr[i][j].getX());
                newArr[i][j].setY(oldArr[i][j].getY());
                newArr[i][j].setTileNum(oldArr[i][j].getTileNum());
            }
        }
        return newArr;
    }

}
