package ca.utoronto.utm.chess;

import java.util.*;

public class cpu_Opponent {

	private int Difficulty;
	private int Team;
	private ArrayList<Integer> OpponentTeams;
	private HashMap<String, Integer> values = new HashMap<String, Integer>();
	
	/**Creates a new instance of the CPU Opponent object.
	 * @param Difficulty
	 * The number of moves the CPU will look ahead each turn.
	 * @param Team
	 * Which team the CPU is. This should reflect the same property as it's pieces.
	 */
	public cpu_Opponent(int Difficulty, int Team, ArrayList<Integer> OpponentTeams) {
		this.Difficulty = Difficulty;
		this.Team = Team;
		this.OpponentTeams = OpponentTeams;
		
		values.put("P", 1); //Pawn
		values.put("N", 5); //Knight
		values.put("R", 5); //Rook
		values.put("B", 5); //Bishop
		values.put("Q", 10); //Queen
		values.put("K", 7); //King
		values.put("x", 0); //Wall
		values.put("o", 0); //None
		
	}
	
	/**Acts as the CPU taking its turn.
	 * @param Board
	 * The current BoardFactory state.
	 * @return A BoardFactory representing the board after the CPU's turn.
	 */
	public BoardFactory makeMove(BoardFactory Board){
		int Move_Count;
		int Best_Score = Integer.MIN_VALUE;
		BoardFactory Best_Play;
		ArrayList<BoardFactory> Possible_Moves;
		
		Possible_Moves = findPossibilities(Board, this.Team);
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
	 * @return An integer representing the score of the board, calculated from possible moves from this state.
	 */
	private int findScore(BoardFactory Board, int Depth){
		int Current_Score = evaluateBoard(Board);
		int Lowest_Score = Integer.MAX_VALUE;
		int Highest_Score = Integer.MIN_VALUE;
		int Opponent_Moves_Count;
		int cpu_Moves_Count;
		BoardFactory Lowest_Board;
		ArrayList<BoardFactory> cpu_Moves;
		ArrayList<BoardFactory> Opponent_Moves;
		
		//First find the opponent's most optimal move for the given cpu move, and add it's score to the 
		//current score.
		Opponent_Moves = findPossibilities(Board, OpponentTeams.get(0));
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
			cpu_Moves = findPossibilities(Lowest_Board, this.Team);
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
	 * @param Team
	 * An integer representing the team for which to find possible moves.
	 * @return An arraylist of all possible moves.
	 */
	private ArrayList<BoardFactory> findPossibilities(BoardFactory Board, int Team){
		ArrayList<PieceFactory> Pieces = (Board.p1.get(0).getOwner() == Team) ? Board.p1 : Board.p2;
		int Piece_Count = Pieces.size();
		ArrayList<BoardFactory> Possibilities = new ArrayList<BoardFactory>();
		
		//Iterate through each piece in the current board. For each piece on the given team, add a new board 
		//state to Possibilities representing each of it's possible moves.
		for(int i = 0; i < Piece_Count; i++) {
			ArrayList<Integer> Moves = Pieces.get(i).possibleMoves();
			int Move_Count = Moves.size();
			
			for(int m = 0; m < Move_Count; m++) {
				Possibilities.add(getNewBoard(Board, Pieces.get(i), Moves.get(m)));
			}
		}
		
		return Possibilities;
	}
	
	
	
	/**Gets the new board after the given move.\nYou'd think this being its own function is kinda dumb, but it's necessary to copy the Board and not change the current one.
	 * @param Board
	 * The board to copy.
	 * @param Piece
	 * The piece to move.
	 * @param move
	 * The move to make.
	 * @return The board after the specified move.
	 */
	private BoardFactory getNewBoard(BoardFactory Board, PieceFactory Piece, int move){
		int P1_Count = Board.p1.size();
		int P2_Count = Board.p2.size();
		
		for(int i = 0; i < P1_Count; i++) {
			if (Board.p1.get(i).id == Piece.id) {
				Board.p1.get(i).move(move);
			}
		}
		for(int i = 0; i < P2_Count; i++) {
			if(Board.p1.get(i).id == Piece.id) {
				Board.p1.get(i).move(move);
			}
		}
		
		return Board;
	}
	
	/**Finds a score value for the given board. Pieces of the same team as this object are valued positively,
	 * while others are valued negatively. The total of these two values is returned and the score of the board.
	 * @param Board
	 * The board of which to find the score value.
	 * @return An integer representing the score of this board.
	 */
	private int evaluateBoard(BoardFactory Board) {
		int Piece_CountC = Board.p2.size();
		int Piece_CountP = Board.p1.size();
		int Score = 0;
		
		//Iterate through each piece on the board, adding or subtracting its value from the total depending
		//on the piece's team.
		for (int i = 0; i < Piece_CountC; i++) {
			Score += values.get(Board.p2.get(i).toString());
		}
		for (int i = 0; i < Piece_CountP; i++) {
			Score -= values.get(Board.p1.get(i).toString());
		}
		
		return Score;
	}
	
}
