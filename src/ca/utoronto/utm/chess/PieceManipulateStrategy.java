package ca.utoronto.utm.chess;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PieceManipulateStrategy implements EventHandler<MouseEvent> {
	
	private Model model;
	
	PieceManipulateStrategy(Model model) {
		this.model = model;
	}
	
	void addCommand(PieceCommand pieceCommand) {
		this.model.addCommand(pieceCommand);
	}
	
	// Handel MouseEvent, concrete methods should be implement depending on different pieces
	@Override
	public void handle(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			this.mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			this.mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			this.mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			this.mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			this.mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			this.mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			this.mouseExited(event);
		}
	}
	protected void mouseMoved(MouseEvent e) { }
	protected void mouseDragged(MouseEvent e) { }
	protected void mouseClicked(MouseEvent e) { }
	protected void mousePressed(MouseEvent e) { }
	protected void mouseReleased(MouseEvent e) { }
	protected void mouseEntered(MouseEvent e) { }
	protected void mouseExited(MouseEvent e) { }
}
