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

		
		if(piece_name.equals("NULL") && prev_piece == "") {
			return;
		}

		if(prev_piece == "") {
			prev_piece = piece_name;
			prev_x = piece_x;
			prev_y = piece_y;
			button.setGraphic(null);
			button.setId("NULL" + " " + piece_x + " " + piece_y);
		}else {
			//HERE WE CAN CHECK IF THE MOVE IS VALID,
			
			this.view.chessBoardPanel.setImg(piece_x, piece_y, prev_piece);
			prev_piece = "";
			
		}
		
		
		//System.out.println(piece + " " + prev_piece);
		
		
		
	}

}
