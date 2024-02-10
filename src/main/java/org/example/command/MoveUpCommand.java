package org.example.command;

import org.example.controller.GameController;
import org.example.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveUpCommand implements Command{


    @Autowired
    private GameController gameController = new GameController();
    @Override
    public Game execute(String input, Game game) {
        if (gameController.isGameOver(game)) {
            System.out.println(gameController.showGameOverMessage(game));
        }

        Game game1 = gameController.makeMove(input, game);

        gameController.showGameBoard(game1);
        return game1;
    }

    @Override
    public boolean matches(String input) {
        return input.equalsIgnoreCase(CommandKeyWords.moveUp);
    }
}
