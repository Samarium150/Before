package ca.utoronto.utm.chess;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class StartPanel extends StackPane {
	protected Canvas canvas;
	protected View view;
	
	public StartPanel(View view) {
		this.view = view;
		this.canvas = new Canvas(800, 600);
		this.getChildren().add(this.canvas);
		this.setStyle("-fx-background-color: pink");
		
		Button button = new Button("Start");
		//this.getChildren().add(button);
		//this.setAlignment(button, Pos.CENTER);

		Button button2 = new Button("Settings");
		//this.getChildren().add(button2);
		//.setAlignment(button2, Pos.);
		
		//Button button3 = new Button("asdfaaa");
		//this.getChildren().add(button3);	
		//this.getChildren().addAll(button,button3);
		Button button3 = new Button("Credits");
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(button, button2, button3);

		this.getChildren().add(vbox);
		StackPane.setAlignment(vbox, Pos.CENTER);
		
	}

}
