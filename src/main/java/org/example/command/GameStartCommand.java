package org.example.command;

import org.example.controller.GameController;
import org.example.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameStartCommand implements Command{
    @Autowired
    private GameController gameController = new GameController();

    public Game execute(String input, Game game) {
        Game game1 = gameController.startGame();

        gameController.showGameBoard(game1);
        return game1;
    }

    @Override
    public boolean matches(String input) {
        return input.equalsIgnoreCase(CommandKeyWords.startGame);
    }
}
