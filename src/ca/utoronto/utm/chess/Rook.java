package ca.utoronto.utm.chess;

import java.util.ArrayList;


public class Rook extends PieceFactory{
	
	Rook(BoardFactory board, int id) {
		this.board = board;
		this.id = id;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		rockOverallMovement(moves);
		return movesFilter(moves);
	}

	@Override
	public String toString() {
		return "R";
	}
}
