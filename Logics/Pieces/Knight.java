package Pieces;

import java.util.ArrayList;

import Board.BoardFactory;

public class Knight extends PieceFactory{
	
	public Knight(BoardFactory board, int id, int owner) {
		this.board = board;
		this.id = id;
		this.owner = owner;
	}
	
	@Override
	public ArrayList<Integer> possibleMoves() {
		int curr = this.board.getPieceLocation(this.id);
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		int[] excludeRight = {6,14,22,30,38,46,54,62};
		int[] excludeRightMost = {7,15,23,31,39,47,55,63};
		int[] excludeLeft = {1,9,17,25,33,41,49,57};
		int[] excludeLeftMost = {0,8,16,24,32,40,48,56};
		if(!(isInArray(excludeRight,curr) || isInArray(excludeRightMost,curr))) moves.add(curr-6);  //
		if(!(isInArray(excludeRight,curr) || isInArray(excludeRightMost,curr))) moves.add(curr+10); //
		if(!(isInArray(excludeLeft,curr) || isInArray(excludeLeftMost,curr))) moves.add(curr-10); //
		if(!(isInArray(excludeLeft,curr) || isInArray(excludeLeftMost,curr))) moves.add(curr+6);  //
		if(!(isInArray(excludeLeftMost,curr))) moves.add(curr-17);
		if(!(isInArray(excludeRightMost,curr))) moves.add(curr+17);
		if(!(isInArray(excludeRightMost,curr))) moves.add(curr-15);
		if(!(isInArray(excludeLeftMost,curr))) moves.add(curr+15);
		return movesFilter(moves);
	}

	@Override
	public String toString() {
		return "N";
	}
	
}
