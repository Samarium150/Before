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


public class View{
	
	private Stage stage;

	

	ChessBoardPanel chessBoardPanel;

	private StartPanel startPanel;
	
	Image icon = new Image(getClass().getResourceAsStream("icon.png"));
	
	BorderPane root = new BorderPane();

	
	View(Stage stage) {
		
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

		menuItem = new MenuItem("New Game");
		menuItem.setId("New Game");
		//menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Help");
		menuItem.setId("Help");
		//menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);
		menuItem = new MenuItem("Main Menu");
		menuItem.setId("Main Menu");
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);
		
		menu.getItems().add(new SeparatorMenuItem());
		
		menuItem = new MenuItem("Exit");
		menuItem.setId("Exit");
		//menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);


		menuBar.getMenus().add(menu);		
		
		return menuBar;
	}

	public void changeToBoard() {
		this.root.setCenter(this.chessBoardPanel);	
	}
	
	public void createNewGame() {
		this.chessBoardPanel = new ChessBoardPanel(this);
		this.root.setCenter(this.chessBoardPanel);	
	}
	
	public void changeToStart() {
		this.root.setCenter(this.startPanel);	
	}
}
