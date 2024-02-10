package org.example.controller;

import org.example.model.Game;
import org.example.model.Tile;
import org.example.service.GameService;
import org.example.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    private GameService gameService;
    private Game game;

    public GameController() {
        this.gameService = new GameService();
        game = new Game();
    }

    public Game startGame() {
        game.setGameBoard(gameService.startGame().getGameBoard());
        game.setScore(gameService.startGame().getScore());
        game.setBest(gameService.startGame().getBest());
        return game;
    }

    public Game makeMove(String moveStep, Game game) {
        Game game1 = new Game();
        game1.setGameBoard(gameService.getMoves(moveStep, game).getGameBoard());
        game1.setScore(gameService.getMoves(moveStep, game).getScore());
        game1.setBest(gameService.getMoves(moveStep, game).getBest());
        return game1;
    }

    public boolean isGameWon(Game game) {
        return gameService.isGameWon(game);
    }

    public boolean isGameOver (Game game) {

        return gameService.isGameOver(game);
    }

    public String showGameOverMessage(Game game) {
        return gameService.showGameOverMessage(game);
    }

    public void showGameBoard(Game game) {
        gameService.printBoard(game);
    }

}
