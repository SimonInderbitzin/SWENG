package ch.fhnw.richards.topic12_Networking.quickTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1", 50001);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());) {
			String message = "Hello from client!";
			out.write(message + "\n");
			out.flush();
			System.out.println("Sent: " + message);
			String reply = in.readLine();
			System.out.println("Received: " + reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
