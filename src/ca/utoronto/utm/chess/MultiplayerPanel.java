package ca.utoronto.utm.chess;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MultiplayerPanel extends StackPane {
	
	View view;
	
	public MultiplayerPanel(View view) {
		this.view = view;
		/*
		TextField text1 = new TextField();
		text1.setPrefColumnCount(20);
		this.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPrefColumnCount(20);
		this.getChildren().add(text2);
		
		*/
		HBox pane = new HBox(5);
		pane.setPadding(new Insets(10));

	

		TextField text1 = new TextField();
		text1.setPrefColumnCount(15);
		pane.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPrefColumnCount(15);
		pane.getChildren().add(text2);
		
		Button connect = new Button("Connect");
		pane.getChildren().add(connect);
		
		this.getChildren().add(pane);                

	}

}
