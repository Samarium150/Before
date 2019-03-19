package ca.utoronto.utm.chess;

import java.util.*;

public class cpu_Opponent {

	private int Difficulty;
	
	public cpu_Opponent(int Difficulty) {
		this.Difficulty = Difficulty;
	}
	
	public ArrayList<PieceCommand> makeMove(ArrayList<PieceCommand> Board){
		int Move_Count;
		int Best_Score = Integer.MIN_VALUE;
		ArrayList<PieceCommand> Best_Play;
		ArrayList<ArrayList<PieceCommand>> Possible_Moves;
		
		Possible_Moves = findMoves(Board);
		Move_Count = Possible_Moves.size();
		
		Best_Play = Possible_Moves.get(0);
		
		for(int i = 0; i < Move_Count; i++) {
				int score;
				score = findScore(Possible_Moves.get(i), Difficulty);
				
				if (score > Best_Score) {
					Best_Score = score;
					Best_Play = Possible_Moves.get(i);
				}
		}
		
		return Best_Play;
	}
	
	private int findScore(ArrayList<PieceCommand> Board, int Depth){
		
		
		
		return 0;
	}
	
	private ArrayList<ArrayList<PieceCommand>> findMoves(ArrayList<PieceCommand> Board/*, String Team*/){ //	TODO: Check for piece's team
		
		return null;
	}
	
	
	
}
