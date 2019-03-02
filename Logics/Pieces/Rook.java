package Pieces;

import java.util.ArrayList;

import Board.BoardFactory;

public class Rook extends PieceFactory{
	
	public Rook(BoardFactory board, int id) {
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
		// TODO Auto-generated method stub
		return "R";
	}
	

}
