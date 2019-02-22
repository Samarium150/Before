package Pieces;

import java.util.ArrayList;

import Board.BoardFactory;

public class Bishop extends PieceFactory{
	
	public Bishop(BoardFactory board, int id, int owner) {
		this.board = board;
		this.id = id;
		this.owner = owner;
	}
	
	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		bishopOverallMovement(moves);
		return movesFilter(moves);
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
