package Pieces;

import java.util.ArrayList;

import Board.BoardFactory;

public class Queen extends PieceFactory{
	
	public Queen(BoardFactory board, int id) {
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
		// TODO Auto-generated method stub
		return "Q";
	}
	
}
