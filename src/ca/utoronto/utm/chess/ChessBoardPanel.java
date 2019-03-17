package ca.utoronto.utm.chess;

import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ChessBoardPanel extends StackPane{
	protected Canvas canvas;
	protected View view;

	
	
	
	public ChessBoardPanel(View view) {
		Button[][] button = new Button[8][8];
		//Button[] button = new Button[8];
		this.view = view;
		this.canvas = new Canvas(800, 600);
		this.getChildren().add(this.canvas);
		this.setStyle("-fx-background-color: teal");


		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				button[i][j] = new Button(i + ":" + j);
				this.getChildren().add(button[i][j]);
			}
			
		}
	
/*		
		Button button1 = new Button("Start");
		this.getChildren().add(button1);
	//	this.setAlignment(button, Pos.CENTER);

		Button button2 = new Button("Settings");
		this.getChildren().add(button2);

		
		Button button3 = new Button("asdfaaa");
		this.getChildren().add(button3);	
		

		

		Button[] buttons = new Button[3];
		
		for(int i = 0; i<3;i++) {
			buttons[i] = new Button("asd");
					
		}
*/	
	}
	

}
