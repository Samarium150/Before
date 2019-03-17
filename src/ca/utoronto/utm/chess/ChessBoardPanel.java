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

	
	Button[][] button = new Button[8][8];
	
	public ChessBoardPanel(View view) {
		this.view = view;
		this.canvas = new Canvas(800, 600);
		this.getChildren().add(this.canvas);
		

	}
	

}
