package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessBoardPanelEventHandler implements EventHandler<ActionEvent>{
	
	static String prev_piece = "";
	static int prev_x = 0;
	static int prev_y = 0;
	View view;
	BoardFactory board;
	Label turn_label;
	
	public ChessBoardPanelEventHandler(View view, BoardFactory board, Label turn_label) {
		this.board = board;
		this.view = view;
		this.turn_label = turn_label;
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
		
		
		String current_turn = this.turn_label.getText();
		
		System.out.println(current_turn + "   " + piece_name);
		
		if (piece_name.substring(0,1).equals(current_turn.substring(0, 1)) == false&& prev_piece.equals("")) {
			return;
		}
		
		
		if (piece_name.equals("NULL") && prev_piece.equals("")) return;
		
		
		
		if (prev_piece.equals("")) {
			prev_piece = piece_name;
			prev_x = piece_x;
			prev_y = piece_y;
			button.setGraphic(null);
			button.setId("NULL" + " " + piece_x + " " + piece_y);
		} else {

			System.out.println(prev_piece + "   " + piece_name);
			String prev_colour = prev_piece.substring(0, 3);
			String curr_colour = piece_name.substring(0, 3);
			if (prev_colour.equals(curr_colour)) {
				this.view.chessBoardPanel.setImg(prev_x, prev_y, prev_piece);
				prev_piece = "";
				return;
			}
			
			if (board.getPiece(pre).move(now)) {
				this.view.chessBoardPanel.setImg(piece_x, piece_y, prev_piece);
			}
			else {
				this.view.chessBoardPanel.setImg(prev_x, prev_y, prev_piece);
			}
			prev_piece = "";
			
			if("w".equals(current_turn.substring(0, 1))) {
				turn_label.setText("black team");
			}else {
				turn_label.setText("white team");
			}
			
		}
	}

}
