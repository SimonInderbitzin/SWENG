package ch.fhnw.richards.topic02_JavaFX.eventHandlingDemo;

public class EventHandlingDemoModel {
	private int value;
	
	protected EventHandlingDemoModel() {
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
