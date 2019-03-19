package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessBoardPanelEventHandler implements EventHandler<ActionEvent>{
	
	static String prev_piece = "";
	static int prev_x = 0;
	static int prev_y = 0;
	View view;
	BoardFactory board = new RegularBoard();
	

	public ChessBoardPanelEventHandler(View view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		String piece = ((Button) event.getSource()).getId();
		Button button = (Button) event.getSource();
		
		String[] piece_parts = piece.split("\\s+");
		String piece_name = piece_parts[0];
		int piece_x = Integer.parseInt(piece_parts[1]);
		int piece_y = Integer.parseInt(piece_parts[2]);
		int now = piece_y + piece_x * 8;
		int pre = prev_y + prev_x * 8;
		System.out.println(String.format("%d %d = %d", piece_x, piece_y, now));
		PieceFactory pi = board.getPiece(now);
		System.out.println(pi);
		
		if (piece_name.equals("NULL") && prev_piece.equals("")) return;
		if (prev_piece.equals("")) {
			prev_piece = piece_name;
			prev_x = piece_x;
			prev_y = piece_y;
			button.setGraphic(null);
			button.setId("NULL" + " " + piece_x + " " + piece_y);
		} else {
			// TODO: (when the move is valid)
			if (board.getPiece(pre).move(now)) {
				this.view.chessBoardPanel.setImg(piece_x, piece_y, prev_piece);
				System.out.println(board);
				prev_piece = "";
			}
		}
	}

}
