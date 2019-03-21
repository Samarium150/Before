package ca.utoronto.utm.chess;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


class View {
	
	private Stage stage;
	
	ChessBoardPanel chessBoardPanel;

	private StartPanel startPanel;
	
	private Image icon;
	
	private BorderPane root = new BorderPane();
	
	View(Stage stage) throws FileNotFoundException{
		this.stage = stage;
		this.initUI(stage); 
	}
	
	private void initUI(Stage stage) throws FileNotFoundException {

		this.chessBoardPanel = new ChessBoardPanel(this);
		this.startPanel = new StartPanel(this);
		this.icon = new Image(new FileInputStream("resources/icon.png"));
		
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
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Help");
		menuItem.setId("Help");
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);
		
		menuItem = new MenuItem("Main Menu");
		menuItem.setId("Main Menu");
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);
		
		menu.getItems().add(new SeparatorMenuItem());
		
		menuItem = new MenuItem("Exit");
		menuItem.setId("Exit");
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);
		
		menuBar.getMenus().add(menu);		
		
		return menuBar;
	}

	void changeToBoard() {
		this.root.setCenter(this.chessBoardPanel);	
	}
	
	void createNewGame(){
		try {
			this.chessBoardPanel = new ChessBoardPanel(this);
			this.root.setCenter(this.chessBoardPanel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	void changeToStart() {
		this.root.setCenter(this.startPanel);	
	}
}
