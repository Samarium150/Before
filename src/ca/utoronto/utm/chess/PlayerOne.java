package ca.utoronto.utm.chess;

public class PlayerOne extends Player {

    public PlayerOne(BoardPanel board, int turnPriority) {
        this.turnPriority = 1 // 1 goes before 2, 2 goes before 3, etc.

        super(board);
    }

    // should have array<> or collection<> before initalizePieces depending on how they are implemented
    public abstract initializePieces() {
        // get array or collection of this player's pieces from the board
        // a placeholder "getPlayerOnePieces()" is used until pieces are coded
        return this.board.getPlayerOnePieces();
    }

    private abstract King detectKing() {
        // search through the player's pieces and if obj is a King, return it
        for(final Piece piece : initializePieces()) {
            // if it is a king
            // ...

            return piece; // or return (King) piece
        }
        // if the loop doesn't return the king then board isn't set up properly
        throw new RuntimeException("board not created properly, no king detected");
    }
}