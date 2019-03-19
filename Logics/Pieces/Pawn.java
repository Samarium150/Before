package Pieces;

import java.util.ArrayList;

import Board.BoardFactory;

public class Pawn extends PieceFactory{
	
	public Pawn(BoardFactory board, int id) {
		this.board = board;
		this.id = id;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		int curr = this.board.getPieceLocation(this.id);
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		int sign = (board.getPieceOwner(this.id) == 1)? 1: -1;
		
		if(board.spotIsVaild(curr+sign*8)) moves.add(curr+sign*8);
		
		if(board.getSquareOwner(curr+sign*9) != 0 && board.getSquareOwner(curr+sign*7) != -1 && board.getSquareOwner(curr+sign*7) != board.getPieceOwner(this.id)) moves.add(curr+sign*7);
		
		if(board.getSquareOwner(curr+sign*9) != 0 && board.getSquareOwner(curr+sign*9) != -1 && board.getSquareOwner(curr+sign*9) != board.getPieceOwner(this.id)) moves.add(curr+sign*9);
		
		return movesFilter(moves);
	}

	@Override
	public String toString() {
		return "P";
	}

}