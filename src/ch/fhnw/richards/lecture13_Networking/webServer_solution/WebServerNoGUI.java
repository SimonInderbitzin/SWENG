package ch.fhnw.richards.lecture13_Networking.webServer_solution;

import java.util.Scanner;

/**
 * When started on a server, we cannot have a GUI. This class provides
 * a way to run the web-server from the command line.
 * 
 * By default, the program will expect web-root in the www subdirectory
 * of whatever directory is is started in; it will then ask the user for
 * a port number.
 * 
 * Alternatively, both port number and web-root (absolute path) can be
 * provided as command-line parameters.
 */
public class WebServerNoGUI {

	public static void main(String[] args) {
		int portNumber = 0;
		String webRoot = "www";

		// If not provided on the command line, read port number
		if (args.length > 0) {
			portNumber = Integer.parseInt(args[0]);
			
			if (args.length > 1) {
				webRoot = args[1];
			}
		} else {
			try (Scanner in = new Scanner(System.in)) {
				boolean valid = false;
	
				while (!valid) {
					System.out.println("Enter the port number on the server (1-65535)");
					String strPort = in.nextLine();
					valid = validatePortNumber(strPort);
					if (valid) portNumber = Integer.parseInt(strPort);
				}
			}
		}
		Model model = new Model();
		model.setPort(portNumber);
		model.setWebroot(webRoot);
		model.setDaemon(false); // Must remain running when main-thread exits
		model.start();
	}
	private static boolean validatePortNumber(String portText) {
		boolean formatOK = false;
		try {
			int portNumber = Integer.parseInt(portText);
			if (portNumber >= 1 & portNumber <= 65535) {
				formatOK = true;
			}
		} catch (NumberFormatException e) {
		}
		return formatOK;
	}
}
