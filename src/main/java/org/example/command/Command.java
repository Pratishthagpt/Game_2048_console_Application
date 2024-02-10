package org.example.command;

import org.example.model.Game;

public interface Command {
    public Game execute(String input, Game game);
    public boolean matches(String input);

}
