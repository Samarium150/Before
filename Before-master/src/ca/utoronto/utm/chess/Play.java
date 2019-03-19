package ca.utoronto.utm.chess;

import javafx.application.Application;
import javafx.stage.Stage;


public class Play extends Application{
	
	private View view;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.view = new View(stage);
	}
}
