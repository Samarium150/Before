package ca.utoronto.utm.chess;

import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

// You may use different Pane
public class BoardPanel extends AnchorPane implements Observer, EventHandler<MouseEvent> {
	private Model model;
	private Canvas canvas;
	private PieceManipulateStrategy strategy;
	
	BoardPanel(Model model) {
		this.canvas = new Canvas(800, 800);
		this.getChildren().add(this.canvas);
		
		// TODO: Change the style or use game board pictures
		this.setStyle("-fx-background-color: white");
		
		this.canvas.addEventHandler(MouseEvent.ANY, this);
		this.setModel(model);
	}
	
	void setModel(Model model) {
		if (model == null) return;
		if (this.model != null) this.model.deleteObserver(this);
		
		this.model = model;
		this.strategy = new PieceManipulateStrategy(this.model);
		this.model.addObserver(this);
		this.refresh();
	}
	
	private void refresh() {
		GraphicsContext g = this.canvas.getGraphicsContext2D();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.model.executeAll(g);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.refresh();
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.strategy.handle(event);
	}
}
