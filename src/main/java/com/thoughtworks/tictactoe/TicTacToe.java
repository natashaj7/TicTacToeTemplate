package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

/**
 * Created by njimenez on 9/24/15.
 */
public class TicTacToe {
    PrintStream printStream;
    BufferedReader nextPlayerMove;
    Board board;

    public TicTacToe(PrintStream printStream, BufferedReader nextPlayerMove, Board board) {
        this.printStream = printStream;
        this.nextPlayerMove = nextPlayerMove;
        this.board=board;
    }

    public void start() {
        printStream.print("   |   |\n" +
                "---------\n" +
                "   |   |\n" +
                "---------\n" +
                "   |   |\n");
    }

    public void getNextMove() {
        printStream.println("Player 1 - Enter a number between 1 and 9:");
        int playerMove=0;
        try {
            playerMove = parseInt(nextPlayerMove.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        board.executeMove(playerMove);
    }
}
