package Main;

import Board.BoardFactory;
import Board.RegularBoard;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Rook;

public class Tester {
	
	public static void main(String[] args) {
		BoardFactory board = new RegularBoard();
		int sqNum = 21;
		board.addPiece(new Rook(board, 39), sqNum, 2);
		System.out.println(board.getSquareNums() + "\n\n" + board);
		System.out.println(board.getPiece(sqNum).getOwner());
		System.out.println(board.getPiece(sqNum).possibleMoves());
		//board.getPiece(1).move(16);
		//System.out.println(board.getSquareNums() + "\n\n" + board);
		//System.out.println(board.getPiece(16).possibleMoves());
	}

}
