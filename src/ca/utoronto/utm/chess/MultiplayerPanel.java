package ca.utoronto.utm.chess;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MultiplayerPanel extends StackPane {
	
	View view;
	
	public MultiplayerPanel(View view) {
		this.view = view;
		
		HBox pane = new HBox(5);
		pane.setPadding(new Insets(10));

	
		TextField text1 = new TextField();
		text1.setPrefColumnCount(15);
		text1.setTooltip(new Tooltip("IP Address"));
		pane.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPrefColumnCount(15);
		text2.setTooltip(new Tooltip("Port Number"));
		pane.getChildren().add(text2);
		
		Button connect_btn = new Button("Connect");
		pane.getChildren().add(connect_btn);
		connect_btn.setOnAction(new MultiplayerPanelEventHandler(this.view,text1,text2));
		
		this.getChildren().add(pane);                

	}

}
