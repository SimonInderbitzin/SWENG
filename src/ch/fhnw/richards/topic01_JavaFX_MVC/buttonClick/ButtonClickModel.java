package ch.fhnw.richards.topic01_JavaFX_MVC.buttonClick;

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
