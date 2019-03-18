package ca.utoronto.utm.chess;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;


public class View implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Model model;
	

	ChessBoardPanel chessBoardPanel;

	private StartPanel startPanel;
	
	Image icon = new Image(getClass().getResourceAsStream("icon.png"));
	
	BorderPane root = new BorderPane();

	
	View(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		this.initUI(stage); 
	}
	
	private void initUI(Stage stage) {

		this.chessBoardPanel = new ChessBoardPanel(this);
		
		//BorderPane root = new BorderPane();
		//root.setCenter(this.chessBoardPanel);

		this.startPanel = new StartPanel(this);
		
		//BorderPane root = new BorderPane();
		root.setTop(createMenuBar());
		root.setCenter(this.startPanel);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Chess");
		stage.setResizable(false);
		stage.getIcons().add(icon);

		stage.show();
		
	}
		
	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		//Creates a new menu for the game option

		menu = new Menu("Game");

		menuItem = new MenuItem("ONE");
		menuItem.setId("New Game");
		menuItem.setDisable(true); // disables button
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("TWO");
		menuItem.setId("TWO");
		menuItem.setDisable(true); // disables button
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("THREE");
		menuItem.setId("THREE");
		menuItem.setDisable(true); // disables button
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Quit");
		menuItem.setId("Quit");
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);		
		
		
		//Creates a new menu for the settings option

		menu = new Menu("Settings");

		menuItem = new MenuItem("ONE");
		menuItem.setId("ONE");
		menuItem.setDisable(true); // disables button
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("TWO");
		menuItem.setId("TWO");
		menuItem.setDisable(true); // disables button
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("THREE");
		menuItem.setId("THREE");
		menuItem.setDisable(true); // disables button
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Rules");


		menuBar.getMenus().add(menu);



		return menuBar;
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO: handle the event on View, like menus
	}

	public void changeToBoard() {
		this.root.setCenter(this.chessBoardPanel);
		
	}
}
