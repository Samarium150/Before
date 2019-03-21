package ca.utoronto.utm.chess;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * the executable class for running the chess game
 */
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
