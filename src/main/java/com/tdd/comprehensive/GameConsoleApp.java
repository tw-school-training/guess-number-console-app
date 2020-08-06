package com.tdd.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

class GameConsoleApp {
    private final BufferedReader bufferReader;
    private final PrintStream printStream;
    private Game game;

    GameConsoleApp(BufferedReader bufferReader, PrintStream printStream, AnswerGenerator answerGenerator) {
        this.bufferReader = bufferReader;
        this.printStream = printStream;
        this.game = new Game(answerGenerator);
    }

    void start() throws IOException {
        printStream.println("Please guess number:");
        while (game.getStatus() == GameStatus.CONTINUED) {
            String userInput = bufferReader.readLine();

            String result = game.guess(userInput);

            printStream.println(String.format("guess result: %s", result));
        }

        if (game.getStatus() == GameStatus.SUCCEED) {
            printStream.println("Congratulations, you succeed!");
        }

        if (game.getStatus() == GameStatus.FAILED) {
            printStream.println("Sorry, you failed!");
        }
    }
}
