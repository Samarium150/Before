package ca.utoronto.utm.chess;

import javafx.application.Application;
import javafx.stage.Stage;

// imports for networking
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
	private boolean isHost = false;
	private boolean playerTurn = false;
	private boolean noCommunication = false;
	private boolean serverAccepted = false;
	private int playerColour = 0; // 0 for white pieces, 1 for black pieces
	private int errors = 0;


	public Play() { // constructor for the class
		System.out.println("Input IP: ");
		ip = scanner.nextLine();
		System.out.println("Input Port: ");
		port = scanner.nextInt();
		while(port < 1 || port > 65535) {
			System.out.println("Invalid port");
			port = scanner.nextInt();
		}

		if (!connect()) createServer();

		// run the game here

	}

	private boolean connect() {
		try {
			socket = new Socket(ip, port);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			serverAccepted = true;
		} catch (IOException e) {
			System.out.println("Unable to connect to the ip: " + ip + ":" + port + " | Starting a server");
			return false;
		}
		System.out.println("Successfully connected to " + ip + ":" + port);
		return true;
	}

	private void createServer() {
		try {
			serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
		} catch (Exception e) {
			e.printStackTrace();
		}
		isHost = true;
		playerTurn = true;
	}

	public void run() { //placeholder for now
		while(true){
			communicationCheck();

			// check if the current turn is yours (depending on what player you are)
			if(playerTurn && !serverAccepted) {
				serverReq();
			}
		}
	}

	private void serverReq() {
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

	public void communicationCheck(){
		if(errors >= 10)
			noCommunication = true;

		if(!playerTurn && !noCommunication){
			try{
				int space = dis.readInt();
				if(playerTurn) playerColour = 0;
				else playerColour = 1;
				//check for checkmate
				playerTurn = true;
			} catch (IOException e) {
				e.printStackTrace();
				errors++;
			}
		}

	}

	public static void main(String[] args) {
		Play chess = new Play();
	}
	
	@Override
	public void start(Stage stage) throws Exception {


		this.model = new Model();
		this.view = new View(model, stage);
	}
}
