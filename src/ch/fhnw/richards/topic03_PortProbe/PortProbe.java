package ch.fhnw.richards.topic03_PortProbe;

import java.util.Scanner;

public class PortProbe {
	
	public static void main(String[] args) {
		ProbeLogic probeLogic;
		String ipAddress = null;
		int portNumber = 0;		
		
		try (Scanner in = new Scanner(System.in)) {
			boolean valid = false;

			// Read IP address
			while (!valid) {
				System.out.println("Enter a valid IP address");
				ipAddress = in.nextLine();
				valid = validateIpAddress(ipAddress);
			}

			// Read port number
			valid = false;
			while (!valid) {
				System.out.println("Enter a valid port number");
				String strPort = in.nextLine();
				valid = validatePortNumber(strPort);
				if (valid) portNumber = Integer.parseInt(strPort);
			}
		}

		// Get logic module
		probeLogic = new ProbeLogic();
		if (probeLogic.probe(ipAddress, portNumber)) {
			System.out.println("Port is open");
		} else {
			System.out.println("Port is closed or stealthed");
		}
	}

	private static boolean validateIpAddress(String ipAddress) {
		boolean formatOK = false;
		// Check for validity (not complete, but not bad)
		String ipPieces[] = ipAddress.split("\\."); // Must escape (see
													// documentation)
		// Must have 4 parts
		if (ipPieces.length == 4) {
			// Each part must be an integer 0 to 255
			formatOK = true; // set to false on the first error
			int byteValue = -1;
			for (String s : ipPieces) {
				byteValue = Integer.parseInt(s); // may throw
													// NumberFormatException
				if (byteValue < 0 | byteValue > 255) formatOK = false;
			}
		}
		return formatOK;
	}

	private static boolean validatePortNumber(String portText) {
		boolean formatOK = false;
		try {
			int portNumber = Integer.parseInt(portText);
			if (portNumber >= 0 & portNumber <= 65535) {
				formatOK = true;
			}
		} catch (NumberFormatException e) {
		}
		return formatOK;
	}

}
