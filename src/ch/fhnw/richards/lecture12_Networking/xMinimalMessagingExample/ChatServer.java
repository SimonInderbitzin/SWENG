package ch.fhnw.richards.lecture12_Networking.xMinimalMessagingExample;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer extends Thread {
	private ArrayList<Socket> clientSockets = new ArrayList<>();
	private ServerSocket listener;

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
		server.waitForStop();
	}

	private ChatServer() {
		super("Server Socket Thread");
	}

	public void waitForStop() {
		// End the server when the user enters "stop"
		System.out.println("Enter 'stop' to end the server");
		try (Scanner in = new Scanner(System.in)) {
			String cmd = in.nextLine();
			while (!cmd.equals("stop"))
				cmd = in.nextLine();
		}

		// Close all sockets, ignore any errors
		closeIgnoreExceptions(listener);
		for (Socket s : clientSockets) {
			closeIgnoreExceptions(s);
		}
	}

	private void closeIgnoreExceptions(Closeable a) {
		try {
			a.close();
		} catch (Exception e) {
		}
	}

	/**
	 * When a client connects: add the Socket to our list, then create and start a
	 * ClientThread. Ends when the ServerSocket is closed.
	 */
	@Override
	public void run() {
		try {
			listener = new ServerSocket(50001, 10, null);
			while (true) {
				Socket clientSocket = listener.accept();
				clientSockets.add(clientSocket);
				ClientThread client = new ClientThread(this, clientSocket.getInputStream());
				client.start();
			}
		} catch (Exception e) {
			// ServerSocket closed
		}
	}

	/**
	 * Send the given message to all clients
	 */
	public void broadcast(String message) {
		for (Socket s : clientSockets) {
			try {
				OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
				out.write(message + "\n");
				out.flush();
			} catch (IOException e) {
				// Ignore errors. Example: our list may contain disconnected sockets
			}
		}
	}
}