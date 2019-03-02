package ca.utoronto.utm.chess;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;


public class View implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Model model;
	
	View(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		this.initUI(stage);
	}
	
	private void initUI(Stage stage) {
		BorderPane root = new BorderPane();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Chess");
		stage.show();
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO: handle the event on View, like menus
	}
}