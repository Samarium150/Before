package ca.utoronto.utm.chess;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

/**
 * the class of the chess game board inherited from Javafx GridPane
 */
public class ChessBoardPanel extends GridPane{
	
	private Canvas canvas;
	private View view;
	protected BoardFactory board = new RegularBoard();

	private Button[][] button = new Button[8][8];
	
	private Image white_pawn, white_rook, white_knight, white_bishop, white_queen, white_king;
	private Image black_pawn, black_rook, black_knight, black_bishop, black_queen, black_king;
	
	ChessBoardPanel(View view) {
		
		white_pawn = new Image(this.getClass().getResource("/white_pawn.png").toString());
		white_rook = new Image(this.getClass().getResource("/white_rook.png").toString());
		white_knight = new Image(this.getClass().getResource("/white_knight.png").toString());
		white_bishop = new Image(this.getClass().getResource("/white_bishop.png").toString());
		white_queen = new Image(this.getClass().getResource("/white_queen.png").toString());
		white_king = new Image(this.getClass().getResource("/white_king1.png").toString());

		black_pawn = new Image(this.getClass().getResource("/black_pawn.png").toString());
		black_rook = new Image(this.getClass().getResource("/black_rook.png").toString());
		black_knight = new Image(this.getClass().getResource("/black_knight.png").toString());
		black_bishop = new Image(this.getClass().getResource("/black_bishop.png").toString());
		black_queen = new Image(this.getClass().getResource("/black_queen.png").toString());
		black_king = new Image(this.getClass().getResource("/black_king1.png").toString());

		String colour_gray = "-fx-background-color:#AAAAAA; -fx-border-color:#AAAAAA;"
				+ "-fx-border-radius: 0, 0, 0, 0;";
		String colour_white = "-fx-background-color:#FFFFFF; -fx-border-color:#FFFFFF"
				+ ";-fx-border-radius: 0, 0, 0, 0;";
		
		this.view = view;
		this.canvas = new Canvas(75, 75);
		this.getChildren().add(this.canvas);
		this.setStyle("-fx-background-color: pink");
		
		Label turn_label = new Label("white team");
		turn_label.setMinWidth(15);
		this.add(turn_label, 0, 0);
		
		int row = 1;
		int col = 1;
		int count = 0;
		this.setVgap(0);
		//adding all the squares to the board
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				button[i][j] = new Button();
				button[i][j].setLineSpacing(1);
				button[i][j].setMinWidth(50);
				button[i][j].setMinHeight(50);
				button[i][j].setId("NULL" + " " + i + " " + j);
				button[i][j].setOnAction(new ChessBoardPanelEventHandler(this.view, board, turn_label));
				
				if(count%2 == 0) {
					button[i][j].setStyle(colour_white);
				}else {
					button[i][j].setStyle(colour_gray);
				}
				
				this.add(button[i][j], col, row);
				
				count++;
				col++;
			}
			col =1;
			count++;
			row++;
			
		}
		
		//assigning graphics to the black pawns
		for(int i = 0; i<8; i++) {
			button[1][i].setGraphic(new ImageView(black_pawn));
			button[1][i].setId("black_pawn" + " " + 1 + " " + i);
		}
		
		//assigning graphics to the black pieces that are not pawns
		button[0][0].setGraphic(new ImageView(black_rook));
		button[0][1].setGraphic(new ImageView(black_knight));
		button[0][2].setGraphic(new ImageView(black_bishop));
		button[0][3].setGraphic(new ImageView(black_queen));
		button[0][4].setGraphic(new ImageView(black_king));
		button[0][5].setGraphic(new ImageView(black_bishop));
		button[0][6].setGraphic(new ImageView(black_knight));
		button[0][7].setGraphic(new ImageView(black_rook));
		
		button[0][0].setId("black_rook"+ " " + 0 + " " + 0);
		button[0][1].setId("black_knight" + " " + 0 + " " + 1);
		button[0][2].setId("black_bishop" + " " + 0 + " " + 2);
		button[0][3].setId("black_queen" + " " + 0 + " " + 3);
		button[0][4].setId("black_king" + " " + 0 + " " + 4);
		button[0][5].setId("black_bishop" + " " + 0 + " " + 5);
		button[0][6].setId("black_knight" + " " + 0 + " " + 6);
		button[0][7].setId("black_rook" + " " + 0 + " " + 7);
		

		//assigning graphics to the white pawns
		for(int i = 0; i<8; i++) {
			button[6][i].setGraphic(new ImageView(white_pawn));
			button[6][i].setId("white_pawn" + " " + 6 + " " + i);
		}
		
		//assigning graphics to the white pieces that are not pawns
		button[7][0].setGraphic(new ImageView(white_rook));
		button[7][1].setGraphic(new ImageView(white_knight));
		button[7][2].setGraphic(new ImageView(white_bishop));
		button[7][3].setGraphic(new ImageView(white_queen));
		button[7][4].setGraphic(new ImageView(white_king));
		button[7][5].setGraphic(new ImageView(white_bishop));
		button[7][6].setGraphic(new ImageView(white_knight));
		button[7][7].setGraphic(new ImageView(white_rook));
		
		button[7][0].setId("white_rook" + " " + 7 + " " + 0);
		button[7][1].setId("white_knight" + " " + 7 + " " + 1);
		button[7][2].setId("white_bishop" + " " + 7 + " " + 2);
		button[7][3].setId("white_queen" + " " + 7 + " " + 3);
		button[7][4].setId("white_king" + " " + 7 + " " + 4);
		button[7][5].setId("white_bishop" + " " + 7 + " " + 5);
		button[7][6].setId("white_knight" + " " + 7 + " " + 6);
		button[7][7].setId("white_rook" + " " + 7 + " " + 7);
	}
	
	/*
	 * This function sets the button[x][y] to the desired piece
	 */
	void setImg(int x, int y, String piece) {
		Image img = null;
		
		switch (piece) {
			case "white_pawn":
				img = white_pawn;
				break;
			case "white_rook":
				img = white_rook;
				break;
			case "white_knight":
				img = white_knight;
				break;
			case "white_bishop":
				img = white_bishop;
				break;
			case "white_queen":
				img = white_queen;
				break;
			case "white_king":
				img = white_king;
				break;
			
			case "black_pawn":
				img = black_pawn;
				break;
			case "black_rook":
				img = black_rook;
				break;
			case "black_knight":
				img = black_knight;
				break;
			case "black_bishop":
				img = black_bishop;
				break;
			case "black_queen":
				img = black_queen;
				break;
			case "black_king":
				img = black_king;
		}
		
		button[x][y].setGraphic(new ImageView(img));
		button[x][y].setId(piece + " " + x + " " + y);
	}
}
