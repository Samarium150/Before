package ca.utoronto.utm.chess;

import java.util.ArrayList;

/**
 * the abstract class for all chess pieces
 */
public abstract class PieceFactory {
	
	public int id;
	
	protected BoardFactory board;
	
	public abstract ArrayList<Integer> possibleMoves();
	public abstract String toString();
	
	ArrayList<Integer> movesFilter(ArrayList<Integer> moves) {
		for(int i = 0; i < moves.size(); i++) {
			if ((moves.get(i) < 0
					|| moves.get(i) >= board.getOverallLocation().length)
					|| board.getSquareOwner(moves.get(i)) == board.getPieceOwner(this.id))  {
				moves.remove(i);
				i--;
			}
		}
		return moves;
	}
	
	public int getOwner() {
		return board.getPieceOwner(this.id);
	}
	
	void rockOverallMovement(ArrayList<Integer> moves) {
		int[] excludeLeftMost = {0,8,16,24,32,40,48,56};
		int[] excludeRightMost = {7,15,23,31,39,47,55,63};
		int[] excludeUpMost = {0,1,2,3,4,5,6,7};
		int[] excludeDownMost = {56,57,58,59,60,61,62,63};
		
		// downward
		straightMovementsStrategy(moves, 8, excludeDownMost);
		
		// upward
		straightMovementsStrategy(moves, -8, excludeUpMost);
		
		// upward
		straightMovementsStrategy(moves, -1, excludeLeftMost);
	
		// upward
		straightMovementsStrategy(moves, 1, excludeRightMost);
		
	}
	
	void bishopOverallMovement(ArrayList<Integer> moves) {
		
		int[] excludeUpLeft = {8,16,24,32,40,48,56,
							   0,1,2,3,4,5,6,7};
		
		int[] excludeUpRight = {15,23,31,39,47,55,63,
				   				0,1,2,3,4,5,6,7};
		
		int[] excludeDownRight = {7,15,23,31,39,47,55,63,
								  56,57,58,59,60,61,62};
		
		int[] excludeDownLeft = {0,8,16,24,32,40,48,
								 56,57,58,59,60,61,62,63};
		
		// up left
		straightMovementsStrategy(moves, -9, excludeUpLeft);
		
		//up right
		straightMovementsStrategy(moves, -7, excludeUpRight);
		
		//down right
		straightMovementsStrategy(moves, 9, excludeDownRight);
	
		//down left
		straightMovementsStrategy(moves, 7, excludeDownLeft);
		
	}
	
	private void straightMovementsStrategy(ArrayList<Integer> moves, int moveNum, int[] bounds) {
		//the piece's current position
		int curr = this.board.getPieceLocation(this.id);
		
		//loop through every tile diagonally and to the left, until you find a tile out of bounds
		for(int temp = curr + moveNum; board.getSquareOwner(temp) != -1; temp += moveNum) {
			//if there's a friendly unit on the specific tile, stop
			if (board.getSquareOwner(temp) == board.getPieceOwner(this.id)) break;
			
			//add the move to the array of possible moves
			moves.add(temp);
			
			if (this.isInArray(bounds, temp)
					|| (board.getSquareOwner(temp) != 0
					&& board.getSquareOwner(temp) != board.getPieceOwner(this.id)))
				break;
			//doesnt check in the direction if the piece is against the wall, or if there's an enemy piece there
		}
	}
	
	public boolean move(int to) {
		if(this.possibleMoves().contains(to)) {
			int toId = this.board.getPiece(to).id;
			PieceFactory buffer = this;
			board.removePiece(toId, this.board.getPieceLocation(toId));
			board.removePiece(id, this.board.getPieceLocation(id));
			board.addPiece(buffer, to, board.getPieceOwner(this.id));
			return true;
		}
		return false;
	}
	
	boolean isInArray(int[] array, int num) {
		for (int n : array) {
			if (n == num) return true;
		}
		return false;
	}
}
