package ca.utoronto.utm.chess;

import java.util.ArrayList;

public class Wall extends PieceFactory{
	
	public Wall() {
		this.id = -10;
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
		return "x";
	}

}
