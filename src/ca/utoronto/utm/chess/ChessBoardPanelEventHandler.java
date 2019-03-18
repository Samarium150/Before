package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessBoardPanelEventHandler implements EventHandler<ActionEvent>{
	
	static String prev_piece = "";
	
	Image white_pawn = new Image(getClass().getResourceAsStream("white_pawn.png"));
	Image white_rook = new Image(getClass().getResourceAsStream("white_rook.png"));
	Image white_knight = new Image(getClass().getResourceAsStream("white_knight.png"));
	Image white_bishop = new Image(getClass().getResourceAsStream("white_bishop.png"));
	Image white_queen = new Image(getClass().getResourceAsStream("white_queen.png"));
	Image white_king = new Image(getClass().getResourceAsStream("white_king1.png"));
	
	Image black_pawn = new Image(getClass().getResourceAsStream("black_pawn.png"));
	Image black_rook = new Image(getClass().getResourceAsStream("black_rook.png"));
	Image black_knight = new Image(getClass().getResourceAsStream("black_knight.png"));
	Image black_bishop = new Image(getClass().getResourceAsStream("black_bishop.png"));
	Image black_queen = new Image(getClass().getResourceAsStream("black_queen.png"));
	Image black_king = new Image(getClass().getResourceAsStream("black_king1.png"));


	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		String piece = ((Button) event.getSource()).getId();
		Button button = (Button) event.getSource();
		
	/*	
		if(piece == "NULL") {
			return;
		}
		*/
		//System.out.println(piece + " " + prev_piece);
		if(prev_piece == "") {
			prev_piece = piece;
			button.setGraphic(null);
			button.setId("NULL");
		}else {
			Image img = null;
			
			if(prev_piece == "white_pawn") {
				img = white_pawn;
			}else if(prev_piece == "white_rook"){
				img = white_rook;
			}else if(prev_piece == "white_knight"){
				img = white_knight;
			}else if(prev_piece == "white_bishop"){
				img = white_bishop;
			}else if(prev_piece == "white_queen"){
				img = white_queen;
			}else if(prev_piece == "white_king"){
				img = white_king;
			}
			
			if(prev_piece == "black_pawn") {
				img = black_pawn;
			}else if(prev_piece == "black_rook"){
				img = black_rook;
			}else if(prev_piece == "black_knight"){
				img = black_knight;
			}else if(prev_piece == "black_bishop"){
				img = black_bishop;
			}else if(prev_piece == "black_queen"){
				img = black_queen;
			}else if(prev_piece == "black_king"){
				img = black_king;
			}
			
			button.setGraphic(new ImageView(img));
			prev_piece = "";
		}
		
		//System.out.println(piece + " " + prev_piece);
		
		
		
	}

}
