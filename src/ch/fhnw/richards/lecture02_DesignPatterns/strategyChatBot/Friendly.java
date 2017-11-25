package ch.fhnw.richards.lecture02_DesignPatterns.strategyChatBot;

public class Friendly implements Personality {

	@Override
	public String getGreeting() {
		double rand = Math.random();
		if (rand < 0.33) return "Hi, pleased to chat with you!";
		else if (rand < 0.67) return "How are you doing today?";
		else return "Great to see you!";
	}

	@Override
	public String answerQuestion() {
		double rand = Math.random();
		if (rand < 0.33) return "Sorry, I didn't get that...";
		else if (rand < 0.67) return "I don't know - I am a bot of very little brain";
		else return "Um...no idea";
	}

	@Override
	public String getFarewell() {
		double rand = Math.random();
		if (rand < 0.33) return "Bye for now";
		else if (rand < 0.67) return "Have a nice day!";
		else return "Goodbye, come back soon";
	}

	@Override
	public String getOther() {
		double rand = Math.random();
		if (rand < 0.33) return "Hey, when the chicken crossed the road, he got to the other side!";
		else if (rand < 0.67) return "Anyway, what's so special about 42?";
		else return "My chips itch...sorry, what did you say?";
	}

}
