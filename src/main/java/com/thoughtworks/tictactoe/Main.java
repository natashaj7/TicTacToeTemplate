package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        String [] boardContents = new String[9];
        for(int i=0; i<boardContents.length;i++) {
            boardContents[i]= " ";
        }
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader nextPlayerMove = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(printStream, boardContents);
        TicTacToe game = new TicTacToe(printStream, nextPlayerMove, board);
        game.start();
        game.getNextMove();

    }
}
