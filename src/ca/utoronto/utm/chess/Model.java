package ca.utoronto.utm.chess;

import java.util.*;
import javafx.scene.canvas.GraphicsContext;

public class Model extends Observable implements Observer {
	
	// stores all commands for drawing pieces on the panel
	private ArrayList<PieceCommand> commands = new ArrayList<>();
	private PlayerOne playerOne;
	private PlayerTwo playerTwo;
	
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

	public void versusAI() {
		// let players choose/randomize if they go first or second, then initalize accordingly
		// ex. if human player goes first, playerOne is a human player and PlayerTwo is AI
		this.playerOne = new PlayerOne(this);
		this.playerTwo = new PlayerTwo(this);
	}

	// create player objects which will control the pieces according to turn order
	public void TwoPlayerGame() {
		this.playerOne = new PlayerOne(this);
		this.playerTwo = new PlayerTwo(this);
	}
	public void ThreePlayerGame() {
		this.playerOne = new PlayerOne(this);
		this.playerTwo = new PlayerTwo(this);
		this.playerThree = new PlayerThree(this);
	}
	public void FourPlayerGame() {
		this.playerOne = new PlayerOne(this);
		this.playerTwo = new PlayerTwo(this);
		this.playerThree = new PlayerThree(this);
		this.playerFour = new PlayerFour(this);
	}
}
