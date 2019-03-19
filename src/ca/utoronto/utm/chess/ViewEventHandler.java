package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ViewEventHandler implements EventHandler<ActionEvent>{
	
	View view;
	
	public ViewEventHandler(View view){
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println("I see you");
		
	}

}
