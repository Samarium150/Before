package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class MultiplayerPanelEventHandler implements EventHandler<ActionEvent> {
	
	
	View view;  
	TextField text1;
	TextField text2;
	
	public MultiplayerPanelEventHandler(View view, TextField text1,TextField text2) {
		this.view = view;
		this.text1 = text1;
		this.text2 = text2;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(this.text1.getText());
		System.out.println(this.text2.getText());
		
	}

}
