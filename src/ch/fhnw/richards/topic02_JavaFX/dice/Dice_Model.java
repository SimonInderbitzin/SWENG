package ch.fhnw.richards.topic02_JavaFX.dice;

public class Dice_Model {
	public int getRandomValue() {
		return (int) (Math.random() * 6 + 1);
	}
}
