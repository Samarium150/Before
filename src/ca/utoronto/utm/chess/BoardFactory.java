package ca.utoronto.utm.chess;

import java.util.ArrayList;

/**
 * Abstract class of chess board
 */
public abstract class BoardFactory {
	
	PieceFactory[] location; // 1D array for all pieces
	ArrayList<PieceFactory> p1 = new ArrayList<>(), p2 = new ArrayList<>();
	public abstract String getSquareNums();
	public abstract String toString();
	
	/**
	 * @param id return the number of the square located, or -1 is not found
	 * @return location of the piece
	 */
	int getPieceLocation(int id) {
		for(int i = 0; i < location.length; i++) {
			if (location[i].id == id) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * initialize the location of all pieces
	 */
	public void initializePieceLocations() {
		for(int i = 0; i < 64; i++) {
			if (location[i].id != -1) {
				location[i].possibleMoves();
			}
		}
	}

	/**
	 * @param id return the input piece belongs to which player, 0 if is not found.
	 * @return the player that owns the piece
	 */
	int getPieceOwner(int id) {
		for(PieceFactory p : p1) {
			if (p.id == id) {
				return 1;
			}
		}
		for(PieceFactory p : p2) {
			if (p.id == id) {
				return 2;
			}
		}
		return -1;
	}
	
	PieceFactory[] getOverallLocation() {
		return location;
	}
	
	PieceFactory getPiece(int squareNum) {
		return (squareNum >= 0 && squareNum < location.length)? location[squareNum] : null;
	}
	
	boolean removePiece(int id , int squareNum) {
		if (location[squareNum].id != -1) {
			location[squareNum] = new None();
			for(int i = 0; i < p1.size(); i++) {
				if (p1.get(i).id == id) p1.remove(i);
				break;
			}
			for(int i = 0; i < p2.size(); i++) {
				if (p2.get(i).id == id) p2.remove(i);
				break;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * return true if is successfully added, or false is invalid
	 * @return whether the action is successful
	 */
	boolean addPiece(PieceFactory piece, int squareNum, int player) {
		if (this.spotIsValid(squareNum)) {
			location[squareNum] = piece;
			if (player == 1) {
				p1.add(piece);	
			}
			if (player == 2) {
				p2.add(piece);
			}
			return true;	
			
		}
		return false;
	}

	
	boolean spotIsValid(int squareNum) {
		return squareNum >= 0 &&  squareNum < location.length && (location[squareNum].id == -1);
	}

	/**
	 * return 0 if p1 won, 1 if p2 won, -1 if is not finished
	 */
	public int gameIsFinished() {
		if(p1.isEmpty()) return 0;
		if(p2.isEmpty()) return 1;
		return -1;
	}
	
	/**
	 * replace all empty spot with None
	 */
	void initializeBoard() {
		for (int i = 0; i < location.length; i++) {
			location[i] = new None();
		}
	}
	
	/**
	 * return the owner of this square, -1 if is failed, 0 if is None.
	 */
	int getSquareOwner(int squareNum) {
		if(squareNum < 0 || squareNum >= location.length) return -1;
		if(location[squareNum].getOwner() >= 1) return location[squareNum].getOwner();
		return 0;
		
	}
}
