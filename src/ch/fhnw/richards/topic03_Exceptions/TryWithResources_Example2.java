package ch.fhnw.richards.topic03_Exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResources_Example2 {

	public static void main(String[] args) {
		File myFile = new File("NameThatDoesNotExist.txt");
		try (InputStream is = new FileInputStream(myFile)) {
			is.read();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}
}
