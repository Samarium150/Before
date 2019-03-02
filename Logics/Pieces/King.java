package Pieces;

import java.util.ArrayList;

import Board.BoardFactory;

public class King extends PieceFactory{

	public King(BoardFactory board, int id) {
		this.board = board;
		this.id = id;
	}
	

	@Override
	public ArrayList<Integer> possibleMoves() {
		int curr = this.board.getPieceLocation(this.id);
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		int[] excludeLeft = {0,8,16,24,32,40,48,56};
		int[] excludeRight = {7,15,23,31,39,47,55,63};
		if(!isInArray(excludeLeft,curr)) moves.add(curr-1);
		if(!isInArray(excludeRight,curr)) moves.add(curr+1);
		moves.add(curr-8);
		moves.add(curr+8);
		return movesFilter(moves);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
}
