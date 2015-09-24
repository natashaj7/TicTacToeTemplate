package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by njimenez on 9/24/15.
 */
public class TicTacToeTest {
    private TicTacToe game;
    private PrintStream printStream;
    private BufferedReader nextPlayerMove;
    private Board board;

    @Before
    public void setup(){
        nextPlayerMove = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board =mock(Board.class);
        game = new TicTacToe(printStream, nextPlayerMove, board);
    }

    @Test
    public void shouldPrintTicTacToeBoardWhenGameStarts(){
        game.start();
        verify(printStream).print(contains("   |   |\n" +
                "---------\n" +
                "   |   |\n" +
                "---------\n" +
                "   |   |\n"));
    }

    @Test
    public void shouldAskUserForInputWhenBoardIsDrawn() throws IOException {
        when(nextPlayerMove.readLine()).thenReturn("1");
        game.getNextMove(1);
        verify(printStream).println(contains("Enter a number"));
    }

    @Test
    public void shouldGetInputWhenUserIsAsked() throws IOException {
        when(nextPlayerMove.readLine()).thenReturn("1");
        game.getNextMove(1);
        verify(nextPlayerMove).readLine();
    }

    @Test
    public void shouldRedrawBoardWhenPlayer1EntersNextMove () throws IOException {
        when(nextPlayerMove.readLine()).thenReturn("1");
        game.getNextMove(1);
        verify(board).executeMove(0,1); //move passed in execute move is one less that inputted bc it is an array index
    }

    public void shouldRedrawBoardWhenPlayer2EntersMove() throws IOException {
        when(nextPlayerMove.readLine()).thenReturn("3");
        game.getNextMove(2);
        verify(board).executeMove(2,2); //move passed in execute move is one less that inputted bc it is an array index
    }

}