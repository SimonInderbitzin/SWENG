package jabberwocky.letterBased.appClasses;

import java.util.ArrayList;
import java.util.HashMap;

import jabberwocky.letterBased.ServiceLocator;
import jabberwocky.letterBased.abstractClasses.Model;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public class App_Model extends Model {
	public static final char START_CHAR = 0x01;
	public static final char END_CHAR = 0x02;
	private int numChars;
	ServiceLocator serviceLocator;
	private HashMap<String, ArrayList<HashEntry>> trainedData = new HashMap<>();

	public App_Model() {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Application model initialized");
	}

	public int getNumEntries() {
		return trainedData.size();
	}

	public int getNumLinks() {
		int sum = 0;
		for (ArrayList<HashEntry> list : trainedData.values()) {
			for (HashEntry he : list)
				sum += he.quantity;
		}
		return sum;
	}
	
	/**
	 * This method clears the training data
	 */
	public void clearTrainingData() {
		trainedData = new HashMap<>();
	}

	/**
	 * This method accepts a string and (if not yet set) the number of prediction
	 * characters. It then processes the string and adds it to the training
	 * database.
	 */
	public void train(int numChars, String data) {
		if (this.numChars <= 0) this.numChars = numChars;
		String sequence = Character.toString(START_CHAR);
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			trainOneChar(sequence, c);
			if (sequence.length() < numChars) {
				sequence = sequence + c;
			} else {
				sequence = sequence.substring(1) + c;
			}
		}
		trainOneChar(sequence, END_CHAR);
	}

	/**
	 * Add one character to the training data
	 */
	private void trainOneChar(String sequence, char c) {
		ArrayList<HashEntry> hashEntries = getHashEntries(sequence);
		boolean found = false;
		for (HashEntry entry : hashEntries) {
			if (entry.followingChar == c) {
				entry.quantity++;
				found = true;
				break;
			}
		}
		if (!found) {
			hashEntries.add(new HashEntry(1, c));
		}
	}

	/**
	 * Generate text using the training data. The generated text does not include
	 * START_CHAR or END_CHAR
	 */
	public String generateText() {
		StringBuffer sb = new StringBuffer();
		String sequence = Character.toString(START_CHAR);
		char c = START_CHAR;
		while (c != END_CHAR) {
			c = genOneChar(sequence);
			if (c != END_CHAR) sb.append(c);

			if (sequence.length() < numChars) {
				sequence = sequence + c;
			} else {
				sequence = sequence.substring(1) + c;
			}
		}
		return sb.toString();
	}

	/**
	 * This method generates a single character, based on the given sequence
	 */
	private char genOneChar(String sequence) {
		ArrayList<HashEntry> hashEntries = trainedData.get(sequence);
		int totalOptions = sum(hashEntries);
		int pick = (int) (Math.random() * totalOptions);
		return pickChar(hashEntries, pick);
	}
	
	/**
	 * Count the total options in the list of HashEntries
	 */
	private int sum(ArrayList<HashEntry> hashEntries) {
		int sum = 0;
		for (HashEntry he : hashEntries) sum += he.quantity;
		return sum;
	}
	
	/**
	 * Pick a character based on the number given
	 */
	private char pickChar(ArrayList<HashEntry> hashEntries, int pick) {
		int sum = 0;
		char c = ' ';
		for (int i = 0; i < hashEntries.size(); i++) {
			HashEntry he = hashEntries.get(i);
			sum += he.quantity;
			if (sum > pick) {
				c = he.followingChar;
				break;
			}
		}
		return c;
	}

	/**
	 * This method returns the list of HashEntries for the character-sequence given.
	 */
	private ArrayList<HashEntry> getHashEntries(String sequence) {
		ArrayList<HashEntry> hashEntries = trainedData.get(sequence);
		if (hashEntries == null) {
			hashEntries = new ArrayList<>();
			trainedData.put(sequence, hashEntries);
		}
		return hashEntries;
	}

	/**
	 * A HashEntry combines an integer - the relative frequency - with a following
	 * character
	 */
	private static class HashEntry {
		int quantity;
		char followingChar;

		private HashEntry(int quantity, char followingChar) {
			this.quantity = quantity;
			this.followingChar = followingChar;
		}
	}
}
