package ca.utoronto.utm.chess;

import javafx.scene.control.Button;
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
		String colour_black = "-fx-background-color:#111111;";	
		String colour_white = "-fx-background-color:#FFFFFF;";
		

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
				button[i][j] = new Button(i + ":" + j);
				button[i][j].setLineSpacing(1);
				button[i][j].setMinWidth(50);
				button[i][j].setPrefHeight(50);
				button[i][j].setId(i + ":" + j);
				button[i][j].setOnAction(new ChessBoardPanelEventHandler());
				
				if(count%2 == 0) {
					button[i][j].setStyle(colour_white);
				}else {
					button[i][j].setStyle(colour_black);
				}
				
				
				this.add(button[i][j], col, row);
				
				count++;
				col++;
			}
			col =1;
			count++;
			row++;
			
		}

	}
	

}
