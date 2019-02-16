package ca.utoronto.utm.chess;

import javafx.scene.canvas.GraphicsContext;

public class PieceVisitor implements Visitor {
	
	private GraphicsContext g;
	
	PieceVisitor(GraphicsContext graphicsContext) {
		this.g = graphicsContext;
	}
	
	@Override
	public void visit(PieceCommand pieceCommand) {
		// TODO: implement by different types of pieceCommand, use GraphicsContext to draw the piece
	}
}
