package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

/**
 * the handler class for the chess board
 */
public class ChessBoardPanelEventHandler implements EventHandler<ActionEvent>{
	
	private static String prev_piece = "";
	private static int prev_x = 0;
	private static int prev_y = 0;
	private View view;
	private BoardFactory board;
	private Label turn_label;
	
	ChessBoardPanelEventHandler(View view, BoardFactory board, Label turn_label) {
		this.board = board;
		this.view = view;
		this.turn_label = turn_label;
	}
	
	@Override
	public void handle(ActionEvent event) {
		String piece = ((Button) event.getSource()).getId();
		Button button = (Button) event.getSource();
		
		String[] piece_parts = piece.split("\\s+");
		String piece_name = piece_parts[0];
		int piece_x = Integer.parseInt(piece_parts[1]);
		int piece_y = Integer.parseInt(piece_parts[2]);
		int now = piece_y + piece_x * 8;
		int pre = prev_y + prev_x * 8;
		
		String current_turn = this.turn_label.getText();
		
		//returns if there is friendly fire, ie black bishop attack black king
		if (piece_name.substring(0,1).equals(current_turn.substring(0, 1)) == false
				&& prev_piece.equals(""))
			return;
		
		//returns if a player is trying to move an empty square
		if (piece_name.equals("NULL") && prev_piece.equals("")) return;
		
		if (prev_piece.equals("")) { //where the piece is coming from
			prev_piece = piece_name;
			prev_x = piece_x;
			prev_y = piece_y;
			button.setGraphic(null);
			button.setId("NULL" + " " + piece_x + " " + piece_y);
		} else { //where the piece is going

			String prev_colour = prev_piece.substring(0, 3);
			String curr_colour = piece_name.substring(0, 3);
			if (prev_colour.equals(curr_colour)) {
				this.view.chessBoardPanel.setImg(prev_x, prev_y, prev_piece);
				prev_piece = "";
				return;
			}
			
			if (board.getPiece(pre).move(now)) {
				this.view.chessBoardPanel.setImg(piece_x, piece_y, prev_piece);

				//This if statement determines which alert to display base on who won
				if(piece_name.equals("white_king")) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Winner!");
					alert.setHeaderText("Congratulations");
					alert.setContentText("The winner is the black team!!!");
					alert.setGraphic(new ImageView(("/black_pawn.png")));
					alert.showAndWait();
					this.view.createNewGame();
				}else if(piece_name.equals("black_king")) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Winner!");
					alert.setHeaderText("Congratulations");
					alert.setContentText("The winner is the white team!!!");
					alert.setGraphic(new ImageView(("/white_pawn.png")));
					alert.showAndWait();
					this.view.createNewGame();
				}	
				
				if("w".equals(current_turn.substring(0, 1))) {
					turn_label.setText("black team");
				}else {
					turn_label.setText("white team");
				}
			}else {
				this.view.chessBoardPanel.setImg(prev_x, prev_y, prev_piece);
			}
			prev_piece = "";
		}
	}
}
