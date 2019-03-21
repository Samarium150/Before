package ca.utoronto.utm.chess;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

class StartPanel extends StackPane {
	
	private Canvas canvas;
	private View view;
	
	Image king2 = new Image(getClass().getResourceAsStream("king2.png"));
	
	StartPanel(View view) {
		this.view = view;
		this.canvas = new Canvas(475, 475);
		this.getChildren().add(this.canvas);
		this.setStyle("-fx-background-color: pink");
		
		Button button = new Button("Start");
		button.setMinWidth(100);
		button.setPrefHeight(50);
		button.setOnAction(new StartPanelEventHandler(this.view));
		
		this.getChildren().add(button);
		this.setAlignment(button, Pos.BOTTOM_CENTER);

		Label label = new Label();
		label.setMinWidth(200);
		label.setPrefHeight(100);
		
		label.setGraphic(new ImageView(king2));
		this.getChildren().add(label);
		this.setAlignment(label, Pos.CENTER);
	}

}
