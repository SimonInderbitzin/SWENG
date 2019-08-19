package ch.fhnw.richards.topic03_PortProbe;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ProbeLogic {
	/**
	 * This method attempts to connect to the given port.
	 * 
	 * @return True if the connection was successful.
	 */
	public boolean probe(String ipAddress, int portNumber) {
		boolean success = false;
		try {
			// Setup the connection
			InetSocketAddress address = new InetSocketAddress(ipAddress, portNumber);
			Socket socket = new Socket();
			
			// Try to connect; timeout after 3 seconds
			socket.connect(address, 3000);
			
			// We will only continue here if the connection is established
			success = true;
			socket.close();
		} catch (IOException e) {
			// System.out.println(e.toString());
			// Failure causes an IOException (includes ConnectException as a subclass)
		}
		return success;
	}
}
