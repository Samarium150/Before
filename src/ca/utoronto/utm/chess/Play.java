package ca.utoronto.utm.chess;

import javafx.application.Application;
import javafx.stage.Stage;

// imports for networking
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Play extends Application{

	private Model model;
	private View view;

	// networking variables needed to communicate
	private String ip = "localhost";
	private int port = 22222;
	private Scanner scanner = new Scanner(System.in);
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private ServerSocket serverSocket;
	private int serverTurn = 1;
	private int playerTurn = 0;
	private boolean noCommunication = false;
	private boolean serverAccepted = false;
	private int errors = 0;


	public Chess() { // constructor for the class
		System.out.println("Input IP: ");
		ip = scanner.nextLine();
		System.out.println("Input Port: ");
		port = scanner.nextInt();
		while(port <1 || port > 65535) {
			System.out.println("Invalid port");
			port = scanner.nextInt();
		}
	}

	public void run() { //placeholder for now
		while(true){
			update();

			// check if the current turn is yours (depending on what player you are)
			if(!(playerTurn == 1) && !serverAccepted) { // not sure if this comparison is the proper way
				listenForServerRequest();
			}
		}
	}

	private void listenForServerRequest() {
		Socket socket = null;
		try {
			socket = serverSocket.accept(); // waits here until we get another connection
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			serverAccepted = true;
			System.out.println("Accepted request to join");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(){ // placeholder for updating the board
		if(errors >= 10)
			noCommunication = true;

		if((serverTurn != playerTurn) && !noCommunication){
			try{
				// using dis (DataInputStream) move the chess piece
				// change serverTurn depending on number of players
				//  check for checkmate
			} catch (IOException e) {
				e.printStackTrace();
				errors++;
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {


		this.model = new Model();
		this.view = new View(model, stage);
	}
}
