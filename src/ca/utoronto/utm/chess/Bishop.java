package ca.utoronto.utm.chess;

import java.util.ArrayList;

/**
 * the class of bishop piece inherited from PieceFactory class
 */
public class Bishop extends PieceFactory{
	
	Bishop(BoardFactory board, int id) {
		this.board = board;
		this.id = id;
	}
	
	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves =  new ArrayList<>();
		bishopOverallMovement(moves);
		return movesFilter(moves);
	}
	
	@Override
	public String toString() {
		return "B";
	}
}
