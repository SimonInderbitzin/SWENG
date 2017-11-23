package ch.fhnw.richards.lecture01_JavaFX.buttonClickMVC;

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
