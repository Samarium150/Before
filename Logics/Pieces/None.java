package Pieces;

import java.util.ArrayList;

public class None extends PieceFactory{
	
	public None () {
		this.id = -1;
	}
	
	@Override
	public boolean move(int to) {return false;}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		return moves;
	}

	@Override
	public String toString() {
		return "o";
	}
	
	public int getOwner() {return 0;}

}
