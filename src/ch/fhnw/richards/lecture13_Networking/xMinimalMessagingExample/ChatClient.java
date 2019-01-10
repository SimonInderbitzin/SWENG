package ch.fhnw.richards.lecture13_Networking.xMinimalMessagingExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
	private BufferedReader socketIn;

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.readUserMessages();
	}

	private ChatClient() {
		super("Read from Server");
	}

	/**
	 * The main thread reads messages from the console and sends them to the server
	 */
	private void readUserMessages() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = in.nextLine();
		System.out.println("Enter IP address of server");
		String msg = in.nextLine();

		// Autoclose: closing socket will also end the thread
		try (Socket socket = new Socket(msg, 50001)) {
			// Create the socket, input and output streams
			OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.start();
			System.out.println("Enter a chat message, or 'stop' to quit");
			while (!msg.equals("stop")) {
				// Read message from the scanner, send to server, flush.
				msg = in.nextLine();
				socketOut.write(name + ": " + msg + "\n");
				socketOut.flush();
			}
		} catch (Exception e) {
			// This happens if the server has closed the socket
		}
		in.close();
	}

	/**
	 * A separate thread monitors the InputStream for messages from the server and
	 * prints them to the console
	 */
	@Override
	public void run() {
		try {
			String message = "";
			while (message != null) {
				message = socketIn.readLine();
				System.out.println(message);
			}
		} catch (IOException e) {
			// Socket was closed
		}
	}
}