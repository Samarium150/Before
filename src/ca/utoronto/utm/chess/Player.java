package ca.utoronto.utm.chess;

import java.util.*;

public abstract class Player {

    // keep track of the board, from BoardPanel class, take the board
    protected BoardPanel board;
    protected King playerKing;
    protected TurnPriority turnPriority;


    Player(BoardPanel board, int turnPriority) {
        this.board = board;
        this.playerKing = detectKing();
    }

    // writing pseudo/placeholder code everwhere until I know how things are implemented


    public abstract initializePieces() {
        // get array or collection of this player's pieces from the board
    }
    private abstract King detectKing() {
        // search through the player's pieces and if obj is a King, return it
    }
}