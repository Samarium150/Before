package ca.utoronto.utm.chess;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MultiplayerPanel extends FlowPane {
	
	View view;
	
	public MultiplayerPanel(View view) {
		this.view = view;
		
		HBox pane = new HBox(5);
		pane.setPadding(new Insets(10));
		
		
		
		Button help = new Button("Help");
		help.setMinWidth(15);
		pane.getChildren().add(help);
		help.setOnAction(new MultiplayerPanelEventHandler(this.view));

	
		TextField text1 = new TextField();
		text1.setPrefColumnCount(15);
		text1.setTooltip(new Tooltip("IP Address"));
		pane.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPrefColumnCount(15);
		text2.setTooltip(new Tooltip("Port Number"));
		pane.getChildren().add(text2);
		
		Button connect_btn = new Button("Go");
		connect_btn.setMinWidth(15);
		pane.getChildren().add(connect_btn);
		connect_btn.setOnAction(new MultiplayerPanelEventHandler(this.view,text1,text2));
		
		/*
		Label label = new Label("To connect please put the IP address into the first textbox and then the port into the second textbox");
		pane.getChildren().add(label);
		this.setAlignment(label, Pos.CENTER);
		*/
		this.getChildren().add(pane);                

	}

}
