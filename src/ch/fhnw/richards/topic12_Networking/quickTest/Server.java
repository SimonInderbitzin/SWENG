package ch.fhnw.richards.topic12_Networking.quickTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket listener = new ServerSocket(50001, 10, null);) {
			// Wait for client to connect
			try (Socket socket = listener.accept();
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());) {
				String message = in.readLine();
				System.out.println("Received: " + message);
				String reply = "Hello from server!";
				out.write(reply + "\n");
				out.flush();
				System.out.println("Sent: " + reply);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
