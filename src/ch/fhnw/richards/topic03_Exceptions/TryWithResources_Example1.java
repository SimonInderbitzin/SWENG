package ch.fhnw.richards.topic03_Exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This is an example of opening a file (that does not exist), showing how we have to handle the errors with try/catch/finally
 */
public class TryWithResources_Example1 {

	public static void main(String[] args) {
		File myFile = new File("NameThatDoesNotExist.txt");
		InputStream is = null;
		try {
			is = new FileInputStream(myFile);
			is.read();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// We don't care about this exception,
				// but we must have the try/catch anyway
			}
		}
	}
}
