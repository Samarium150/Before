package Board;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.None;
import Pieces.Pawn;
import Pieces.PieceFactory;
import Pieces.Queen;
import Pieces.Rook;

public class RegularBoard extends BoardFactory{
	
	public RegularBoard() {
		location = new PieceFactory[64]; // 8 x 8
		/*   0  1  2  3  4  5  6  7 
 		 *   8  9 10 11 12 13 14 15 
		 *	16 17 18 19 20 21 22 23 
		 * 	24 25 26 27 28 29 30 31 
		 *	32 33 34 35 36 37 38 39 
		 *	40 41 42 43 44 45 46 47 
		 *	48 49 50 51 52 53 54 55 
		 *	56 57 58 59 60 61 62 63
		 *	# You can also see the nums by calling [getSquareNums()]
		 */
		this.initializeBoard();
		this.addPiece(new King(this, 1), 4, 1);
		this.addPiece(new King(this, 2), 60, 2);

		this.addPiece(new Queen(this, 11), 3, 1);
		this.addPiece(new Queen(this, 12), 59, 2);
		
		this.addPiece(new Knight(this, 21), 1, 1);
		this.addPiece(new Knight(this, 22), 6, 1);
		this.addPiece(new Knight(this, 23), 57, 2);
		this.addPiece(new Knight(this, 24), 62, 2);
		
		this.addPiece(new Rook(this, 31), 0, 1);
		this.addPiece(new Rook(this, 32), 7, 1);
		this.addPiece(new Rook(this, 33), 56, 2);
		this.addPiece(new Rook(this, 34), 63, 2);
		
		this.addPiece(new Bishop(this, 41), 2, 1);
		this.addPiece(new Bishop(this, 42), 5, 1);
		this.addPiece(new Bishop(this, 43), 58, 2);
		this.addPiece(new Bishop(this, 44), 61, 2);
		
		this.addPiece(new Pawn(this, 51), 8, 1);
		this.addPiece(new Pawn(this, 52), 9, 1);
		this.addPiece(new Pawn(this, 53), 10, 1);
		this.addPiece(new Pawn(this, 54), 11, 1);
		this.addPiece(new Pawn(this, 55), 12, 1);
		this.addPiece(new Pawn(this, 56), 13, 1);
		this.addPiece(new Pawn(this, 57), 14, 1);
		this.addPiece(new Pawn(this, 58), 15, 1);
		
		this.addPiece(new Pawn(this, 61), 48, 2);
		this.addPiece(new Pawn(this, 62), 49, 2);
		this.addPiece(new Pawn(this, 63), 50, 2);
		this.addPiece(new Pawn(this, 64), 51, 2);
		this.addPiece(new Pawn(this, 65), 52, 2);
		this.addPiece(new Pawn(this, 66), 53, 2);
		this.addPiece(new Pawn(this, 67), 54, 2);
		this.addPiece(new Pawn(this, 68), 55, 2);
	}

	@Override
	public String getSquareNums() {
		String rt = "";
		for (int i = 0; i < location.length; i++) {
			rt += "["+((i+1 <= 10)? " ":"") + i + "]";
			if ( (i+1) % 8 == 0) {
				rt += "\n";
			}
		}
		return rt;
	}

	@Override
	public String toString() {
		String rt = "";
		for (int i = 0; i < location.length; i++) {
			rt += "[" + location[i] + "]";
			if ( (i+1) % 8 == 0) {
				rt += "\n";
			}
		}
		return rt;
	}

}
