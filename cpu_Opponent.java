package ca.utoronto.utm.chess;

import java.util.*;

public class cpu_Opponent {

	private int Difficulty;
	private int Team;
	
	/**Creates a new instance of the CPU Opponent object.
	 * @param Difficulty
	 * The number of moves the CPU will look ahead each turn.
	 * @param Team
	 * Which team the CPU is. This should reflect the same property as it's pieces.
	 */
	public cpu_Opponent(int Difficulty, int Team) {
		this.Difficulty = Difficulty;
		this.Team = Team;
	}
	
	/**Acts as the CPU taking it's turn.
	 * @param Board
	 * An ArrayList of PieceCommands representing previous board state.
	 * @return An ArrayList of PieceCommands representing the board state after the CPU's turn.
	 */
	public ArrayList<PieceCommand> makeMove(ArrayList<PieceCommand> Board){//									TODO: Make sure this is the proper format for the turns
		int Move_Count;
		int Best_Score = Integer.MIN_VALUE;
		ArrayList<PieceCommand> Best_Play;
		ArrayList<ArrayList<PieceCommand>> Possible_Moves;
		
		Possible_Moves = findMoves(Board);
		Move_Count = Possible_Moves.size();
		
		Best_Play = Possible_Moves.get(0);
		
		//Iterate through all posible moves for the CPU, getting a score for each. The move with the highest outcome is the returned board.
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
	
	/**Finds the score of the given board. For use in determining the best play for the CPU opponent to make.
	 * @param Board 
	 * The game state to be evaluated.
	 * @param Depth
	 * The number of turns to consider in the scoring. Also reflects the recursion depth.
	 * @return And integer representing th score of the board, calculated from possible moves from this state.
	 */
	private int findScore(ArrayList<PieceCommand> Board, int Depth){
		int Current_Score = evaluateBoard(Board);
		int Lowest_Score = Integer.MAX_VALUE;
		int Highest_Score = Integer.MIN_VALUE;
		int Opponent_Moves_Count;
		int cpu_Moves_Count;
		ArrayList<PieceCommand> Lowest_Board;
		ArrayList<ArrayList<PieceCommand>> cpu_Moves;
		ArrayList<ArrayList<PieceCommand>> Opponent_Moves;
		
		//First find the opponent's most optimal move for the given cpu move, and add it's score to the 
		//current score.
		Opponent_Moves = findMoves(Board); //																	TODO: Specify team
		Lowest_Board = Opponent_Moves.get(0);
		Opponent_Moves_Count = Opponent_Moves.size();
			
		for(int i = 0; i < Opponent_Moves_Count; i++) {
			int score = evaluateBoard(Opponent_Moves.get(i));
			if(score < Lowest_Score) {
				score = Lowest_Score;
				Lowest_Board = Opponent_Moves.get(i);
			}
		}
		Current_Score += Lowest_Score;
		
		if (Depth > 1) {
			//Recursively score every possible move for the cpu to make, and add the highest scored one 
			//to the current score.
			cpu_Moves = findMoves(Lowest_Board); //																TODO: Specify team
			cpu_Moves_Count = cpu_Moves.size();
			
			for(int i = 0; i < cpu_Moves_Count; i++) {
				//Recursion step on Depth-1, and the possible moves from the player's best move.
				int score = findScore(cpu_Moves.get(i), Depth - 1); 
				if(score < Highest_Score) {
					score = Highest_Score;
				}
			}
			Current_Score += Highest_Score;
		}
		
		return Current_Score;
	}
	
	/**Finds all possible moves for a given player and board, and returns them as an arraylist of board states.
	 * @param Board
	 * The board of which to find all possible moves.
	 * @return An arraylist of all possible moves.
	 */
	private ArrayList<ArrayList<PieceCommand>> findMoves(ArrayList<PieceCommand> Board/*, String Team*/){ //	TODO: Check for piece's team
		int Piece_Count = Board.size();
		ArrayList<ArrayList<PieceCommand>> Possibilities = new ArrayList<ArrayList<PieceCommand>>();
		
		//Iterate through each piece in the current board. For each piece on the given team, add a new board 
		//state to Possibilities representing each of it's possible moves.
		for(int i = 0; i < Piece_Count; i++) {
			//if (Board.get(i).Team == this.Team) { //															TODO: Check for piece's team
				//																								TODO: Iterate through each piece's possible moves, and add the new board state accordingly
			//}
		}
		
		return Possibilities;
	}
	
	/**Finds a score value for the given board. Pieces of the same team as this object are valued positively,
	 * while others are valued negatively. The total of these two values is returned and the score of the board.
	 * @param Board
	 * The board of which to find the score value.
	 * @return An integer representing the score of this board.
	 */
	private int evaluateBoard(ArrayList<PieceCommand> Board) {
		int Piece_Count = Board.size();
		int Score = 0;
		
		//Iterate through each piece on the board, adding or subtracting its value from the total depending
		//on the piece's team.
		for (int i = 0; i < Piece_Count; i++) {
			/*																									TODO: Check piece's team and value
			PieceCommand Piece = Board.get(i);
			if (Piece.Team == this.Team) {
				Score += Piece.GetValue();
			}
			else {
				Score -= Piece.GetValue();
			}
			*/
		}
		
		return Score;
	}
	
}
