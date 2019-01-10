package ch.fhnw.richards.lecture03_DesignPatterns.strategyChatBot;

public interface Personality {
	public abstract String getGreeting();
	public abstract String answerQuestion();
	public abstract String getFarewell();
	public abstract String getOther();
}
