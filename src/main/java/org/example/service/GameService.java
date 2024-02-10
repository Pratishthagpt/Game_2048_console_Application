package org.example.service;

import org.example.exception.InvalidMoveException;
import org.example.model.Game;
import org.example.model.GameBoard;
import org.example.model.Tile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private MoveService moveService;
    private Game game;

    public GameService() {
        this.moveService = new MoveService();
    }

    public Game startGame() {
        game = new Game();
        game.initializeGame();
        game = moveService.addNewTile(game);
        game = moveService.addNewTile(game);
        return game;
    }

    public Game getMoves(String moveStep, Game game) {
        if (moveStep.equals("0")) {
            return moveService.moveLeft(game);
        }
        else if (moveStep.equals("1")) {
            return moveService.moveRight(game);
        }
        else if (moveStep.equals("2")) {
            return moveService.moveTop(game);
        }
        else if (moveStep.equals("3")) {
            return moveService.moveBottom(game);
        }
        else {
            throw new InvalidMoveException("Invalid move step. Please enter the correct move number");
        }
    }

    public boolean isGameWon(Game game) {
        GameBoard board = game.getGameBoard();
        Tile[][] grid = new Tile[board.getBoard_size()][board.getBoard_size()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(board.getGrid()[i][j].getX());
                grid[i][j].setY(board.getGrid()[i][j].getY());
                grid[i][j].setTileNum(board.getGrid()[i][j].getTileNum());
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getTileNum().equals("2048")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGameOver (Game game) {

        GameBoard board = game.getGameBoard();
        Tile[][] grid = new Tile[board.getBoard_size()][board.getBoard_size()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Tile(i, j, "_");
                grid[i][j].setX(board.getGrid()[i][j].getX());
                grid[i][j].setY(board.getGrid()[i][j].getY());
                grid[i][j].setTileNum(board.getGrid()[i][j].getTileNum());
            }
        }

        if (isGameWon(game)) {
            return true;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getTileNum().equals("_") ||
                        (i > 0 && grid[i][j].getTileNum().equals(grid[i-1][j].getTileNum())) ||
                        (i < grid.length - 1 && grid[i][j].getTileNum().equals(grid[i+1][j].getTileNum())) ||
                        (j > 0 && grid[i][j].getTileNum().equals(grid[i][j-1].getTileNum())) ||
                        (j < grid.length - 1 && grid[i][j].getTileNum().equals(grid[i][j+1].getTileNum()))
                ) {
                    return false;
                }
            }
        }
        return true;
    }

    public String showGameOverMessage(Game game) {
        if (isGameWon(game)) {
            return "Congratulations";
        }
        else if (isGameOver(game)) {
            return "Game over";
        }
        return "";
    }

    public void printBoard(Game game) {
        game.displayBoard(game.getGameBoard());
    }
}
