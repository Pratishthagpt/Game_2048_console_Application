package org.example;

import org.example.command.*;
import org.example.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
public class Game_2048_consoleApplication implements CommandLineRunner {

    @Autowired
    private CommandExecutor commandExecutor;
    private Game game = new Game();

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(Game_2048_consoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        commandExecutor.addCommand(new GameStartCommand());
        commandExecutor.addCommand(new MoveDownCommand());
        commandExecutor.addCommand(new MoveUpCommand());
        commandExecutor.addCommand(new MoveLeftCommand());
        commandExecutor.addCommand(new MoveLeftCommand());
        commandExecutor.addCommand(new MoveRightCommand());

        while (true) {
            System.out.println("Please enter the input: \n 1. StartGame \n 2. 0 - Move Left" +
                    "\n 3. 1 - Move Right \n 4. 2 - Move Up \n 5. 3 - Move Down ");

            String input = sc.nextLine();
            game = commandExecutor.execute(input, game);
        }

    }
}