package ca.utoronto.utm.chess;

import java.util.*;
import javafx.scene.canvas.GraphicsContext;

public class Model extends Observable implements Observer {
	
	// stores all commands for drawing pieces on the panel
	private ArrayList<PieceCommand> commands = new ArrayList<>();
	
	void addCommand(PieceCommand pieceCommand) {
		pieceCommand.addObserver(this);
		this.commands.add(pieceCommand);
		this.setChanged();
		this.notifyObservers();
	}
	
	// execute all commands to draw pieces
	void executeAll(GraphicsContext g){
		PieceVisitor pieceVisitor = new PieceVisitor(g);
		for (PieceCommand c: commands) {
			c.accept(pieceVisitor);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}
}
