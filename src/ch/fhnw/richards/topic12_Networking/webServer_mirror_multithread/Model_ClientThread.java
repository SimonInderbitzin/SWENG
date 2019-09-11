package ch.fhnw.richards.topic12_Networking.webServer_mirror_multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Model_ClientThread extends Thread {
	private static int clientNumber = 0;
	private final Logger logger = Logger.getLogger("");
	private Socket socket;

	public Model_ClientThread(Socket socket) {
		super("Client thread" + clientNumber++);
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());) {

			logger.info("Request from client " + socket.getInetAddress().toString() + " for server "
					+ socket.getLocalAddress().toString());

			// Send our reply using HTTP 1.0
			// HTTP specifies \r\n line endings, though most programs don't care
			out.print("HTTP/1.0 200 \r\n"); // Version and status
			out.print("Content-Type: text/plain\r\n");
			out.print("\r\n"); // Required empty line

			// Read request from client and send it straight back
			// An empty string (length 0) is the end of an HTTP request
			StringBuilder received = new StringBuilder();
			String inString;
			while ((inString = in.readLine()) != null && inString.length() != 0) {
				received.append(inString + "\n");
			}

			// Send request back as our output
			String outString = received.toString();
			out.print(outString);
			logger.info("Request contents:\n" + outString);

			out.flush(); // Be safe, always "flush"
			socket.close();
		} catch (IOException e) {
			logger.warning(e.toString());
		}
	}
}
