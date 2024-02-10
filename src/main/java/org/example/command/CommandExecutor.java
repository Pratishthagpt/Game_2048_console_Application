package org.example.command;

import org.example.model.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand (Command command) {
        commands.add(command);
    }
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public Game execute (String input, Game game) {
        for (Command command : commands) {
            if(command.matches(input)) {
                return command.execute(input, game);
            }
        }
        return null;
    }
}
