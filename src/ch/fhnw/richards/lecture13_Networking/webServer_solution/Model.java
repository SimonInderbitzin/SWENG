package ch.fhnw.richards.lecture13_Networking.webServer_solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.concurrent.Task;

/**
 * Model is a thread, so that it can work without blocking the GUI
 */
public class Model extends Thread {
	private Integer port;
	private String webRoot = "www";
	private final Logger logger = Logger.getLogger("");

	public Model() {
		super("ServerSocket");
	}

	@Override
	public void run() {
		try (ServerSocket listener = new ServerSocket(port, 10, null)) {
			logger.info("Listening on port " + port);

			while (true) {
				// Wait for request, then create input/output streams to talk to the client
				Socket socket = listener.accept();
				Model_ClientThread client = new Model_ClientThread(socket, webRoot);
				client.start();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	};

	public void setPort(Integer port) {
		this.port = port;
	}
	
	public void setWebroot(String webRoot) {
		this.webRoot = webRoot;
	}
}
