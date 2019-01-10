package ch.fhnw.richards.lecture13_Networking.browser_url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;

public class BrowserModel {
	public String browse(String urlString) {
		StringBuffer headers = new StringBuffer();
		String lineIn;
		StringBuffer urlContent = new StringBuffer();

		// Network errors are always possible
		try {
			// Create a new URL-Object
			URL url = new URL(urlString);

			// The URLConnection from the URL. This provides access to headers
			URLConnection in = url.openConnection();
			headers.append("Content encoding: " + in.getContentEncoding() + "\n");
			headers.append("Content type: " + in.getContentType() + "\n");
			headers.append("Last modified: " + Instant.ofEpochMilli(in.getLastModified()).toString() + "\n\n");

			if (in instanceof HttpURLConnection) {
				HttpURLConnection in_http = (HttpURLConnection) in;
				headers.append("HTTP Status-Code: " + in_http.getResponseCode() + "\n\n");
			}

			try (BufferedReader inReader = new BufferedReader(new InputStreamReader(in.getInputStream()));) {
				while ((lineIn = inReader.readLine()) != null) {
					urlContent.append(lineIn + "\n");
				}
			}

			return headers.toString() + urlContent.toString();
		} catch (Exception err) {
			// If an error occurred, return the error message
			return "ERROR: " + err.toString();
		}
	}
}
