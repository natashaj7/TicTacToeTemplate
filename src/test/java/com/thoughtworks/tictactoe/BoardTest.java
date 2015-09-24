package com.thoughtworks.tictactoe;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by njimenez on 9/24/15.
 */
public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private String [] boardContents;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        boardContents = new String[9];
        for (int i = 0; i < boardContents.length; i++) {
            boardContents[i] = " ";
        }
        board = new Board(printStream, boardContents);
    }

    @Test
    public void shouldSetBoardWithXWhenPlayer1ChoosesLocation(){
        board.executeMove(2);
        assertEquals("X", boardContents[2]);
    }

    @Test
    public void shouldDrawWhenBoardIsSet(){
        board.executeMove(2);
        verify(printStream).println(contains("   |   | X"));
    }

}