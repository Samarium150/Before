package ca.utoronto.utm.chess;

import java.util.ArrayList;

/**
 * the class of queen piece inherited from PieceFactory class
 */
public class Queen extends PieceFactory{
	
	Queen(BoardFactory board, int id) {
		this.board = board;
		this.id = id;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		bishopOverallMovement(moves);
		rockOverallMovement(moves);
		return movesFilter(moves);
	}

	@Override
	public String toString() {
		return "Q";
	}
}
