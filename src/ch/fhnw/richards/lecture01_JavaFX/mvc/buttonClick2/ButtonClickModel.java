package ch.fhnw.richards.lecture01_JavaFX.mvc.buttonClick2;

public class ButtonClickModel {
	private int value;
	
	protected ButtonClickModel() {
		value = 0;
	}
	
	public int getValue() {
		return value;
	}
	
	public int incrementValue() {
		value++;
		return value;
	}
}
