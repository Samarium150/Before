package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MultiplayerPanelEventHandler implements EventHandler<ActionEvent> {
	
	
	View view;  
	TextField text1;
	TextField text2;
	Image warning = new Image(getClass().getResourceAsStream("warning.png"));
	
	public MultiplayerPanelEventHandler(View view, TextField text1,TextField text2) {
		this.view = view;
		this.text1 = text1;
		this.text2 = text2;
	}

	public MultiplayerPanelEventHandler(View view2) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		
		String button_name = ((Button) event.getSource()).getText();
		
		if(button_name.equals("Help")) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Help!");
	        alert.setHeaderText("Connection instructions");
	        alert.setContentText("To connect please type the IP address into the first box and "
	        		+ "then the port number into the second box.");
	        alert.setGraphic(new ImageView(warning));
	        alert.showAndWait();
		}else {
			System.out.println(this.text1.getText());
			System.out.println(this.text2.getText());
		}
	}

}
