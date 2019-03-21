package ca.utoronto.utm.chess;

import java.util.ArrayList;

/**
 * the class of none piece inherited from PieceFactory class
 * used for filling out the game board
 */
public class None extends PieceFactory{
	
	None() {
		this.id = -1;
	}
	
	@Override
	public boolean move(int to) {return false;}

	@Override
	public ArrayList<Integer> possibleMoves() {
		return new ArrayList<>();
	}

	@Override
	public String toString() {
		return "o";
	}
	
	public int getOwner() {return 0;}
}
