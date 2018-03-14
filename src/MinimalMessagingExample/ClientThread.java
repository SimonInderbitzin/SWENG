package MinimalMessagingExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A ClientThread monitors the InputStream of a Socket for incoming messages
 */
public class ClientThread extends Thread {
	private static int nextClientID = 0;
	private ChatServer server;
	private BufferedReader in;

	public ClientThread(ChatServer server, InputStream in) {
		super("Client " + nextClientID++);
		this.server = server;
		this.in = new BufferedReader(new InputStreamReader(in));
	}

	/**
	 * Read an incoming message, then use the server's broadcast method to send it to
	 * all clients. The endless loop is ended by closing the socket - this will generate
	 * an IOException on "in.readLine".
	 */
	@Override
	public void run() {
		try {
			while (true) {
				String message = in.readLine();
				server.broadcast(message);
			}
		} catch (IOException e) {
		}
		System.out.println(this.getName() + " terminated");
	}
}