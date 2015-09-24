package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by njimenez on 9/24/15.
 */
public class Board {

    //private ArrayList <Boolean> board = new ArrayList<>();
    String [] board;
    PrintStream printStream;

    Board(PrintStream printStream, String[] board){
        this.printStream = printStream;
        this.board=board;
    }

    public void executeMove(int playerMove) {
        board[playerMove]="X";
        draw();
    }

    private void draw(){
        String strFormat = " %s | %s | %s\n---------\n %s | %s | %s\n---------\n %s | %s | %s\n";
        String tttboard = String.format(strFormat,board);
        printStream.print(tttboard);
    }
}
