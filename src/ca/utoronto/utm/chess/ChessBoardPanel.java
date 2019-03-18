package ca.utoronto.utm.chess;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ChessBoardPanel extends GridPane{
	protected Canvas canvas;
	protected View view;

	
	
	
	public ChessBoardPanel(View view) {
		Button[][] button = new Button[8][8];
		//String colour_black = "-fx-background-color:#111111;";	
		//String colour_gray = "-fx-background-color:#AAAAAA;";	
		//String colour_white = "-fx-background-color:#FFFFFF;";
		
		String colour_gray = "-fx-background-color:#AAAAAA; -fx-border-color:#AAAAAA;"
				+ "-fx-border-radius: 0, 0, 0, 0;";
		String colour_white = "-fx-background-color:#FFFFFF; -fx-border-color:#FFFFFF"
				+ ";-fx-border-radius: 0, 0, 0, 0;";
		
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

		this.view = view;
		this.canvas = new Canvas(50, 50);
		this.getChildren().add(this.canvas);
		this.setStyle("-fx-background-color: teal");

		
		int row = 1;
		int col = 1;
		int count = 0;
		this.setVgap(0);
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				//button[i][j] = new Button(i + ":" + j);
				button[i][j] = new Button();
				button[i][j].setLineSpacing(1);
				button[i][j].setMinWidth(50);
				button[i][j].setPrefHeight(50);
				button[i][j].setId(i + ":" + j);
				button[i][j].setOnAction(new ChessBoardPanelEventHandler());
				//[i][j].setGraphic(new ImageView(white_pawn));
				
				if(count%2 == 0) {
					button[i][j].setStyle(colour_white);
				}else {
					button[i][j].setStyle(colour_gray);
				}
				
				
				this.add(button[i][j], col, row);
				
				count++;
				col++;
			}
			col =1;
			count++;
			row++;
			
		}
		
		for(int i = 0; i<8; i++) {
			button[1][i].setGraphic(new ImageView(black_pawn));
		}
		
		button[0][0].setGraphic(new ImageView(black_rook));
		button[0][1].setGraphic(new ImageView(black_knight));
		button[0][2].setGraphic(new ImageView(black_bishop));
		button[0][3].setGraphic(new ImageView(black_queen));
		button[0][4].setGraphic(new ImageView(black_king));
		button[0][5].setGraphic(new ImageView(black_bishop));
		button[0][6].setGraphic(new ImageView(black_knight));
		button[0][7].setGraphic(new ImageView(black_rook));
		
		
		
		
		for(int i = 0; i<8; i++) {
			button[6][i].setGraphic(new ImageView(white_pawn));
		}
		
		button[7][0].setGraphic(new ImageView(white_rook));
		button[7][1].setGraphic(new ImageView(white_knight));
		button[7][2].setGraphic(new ImageView(white_bishop));
		button[7][3].setGraphic(new ImageView(white_queen));
		button[7][4].setGraphic(new ImageView(white_king));
		button[7][5].setGraphic(new ImageView(white_bishop));
		button[7][6].setGraphic(new ImageView(white_knight));
		button[7][7].setGraphic(new ImageView(white_rook));
		
		
		
		
		
	}


}
