package ca.utoronto.utm.chess;

import java.util.ArrayList;

/**
 * the class of king piece inherited from PieceFactory class
 */
public class King extends PieceFactory{

	King(BoardFactory board, int id) {
		this.board = board;
		this.id = id;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		int curr = this.board.getPieceLocation(this.id);
		ArrayList<Integer> moves =  new ArrayList<Integer>();
		int[] excludeLeft = {0,8,16,24,32,40,48,56};
		int[] excludeRight = {7,15,23,31,39,47,55,63};
		int[] excludeBottom = {56,57,58,59,60,61,62,63};
		int[] excludeTop = {0,1,2,3,4,5,6,7};

		if(!isInArray(excludeLeft,curr)) {
			moves.add(curr-1);
			moves.add(curr+7);
			moves.add(curr-9);
		}
		if(!isInArray(excludeRight,curr)) {
			moves.add(curr+1);
			moves.add(curr-7);
			moves.add(curr+9);
		}
		if(!isInArray(excludeBottom,curr)) moves.add(curr+8);
		if(!isInArray(excludeTop,curr)) moves.add(curr-8);
		return movesFilter(moves);
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
