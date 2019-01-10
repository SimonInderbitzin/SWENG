package ch.fhnw.richards.lecture03_DesignPatterns.strategyChatBot;

public class Insulting implements Personality {

	@Override
	public String getGreeting() {
		double rand = Math.random();
		if (rand < 0.33) return "Bugger off, I was sleeping";
		else if (rand < 0.67) return "Whaddya want";
		else return "Great, you're here, can you leave now?";
	}

	@Override
	public String answerQuestion() {
		double rand = Math.random();
		if (rand < 0.33) return "What, do you think I'm here to serve you?";
		else if (rand < 0.67) return "Go ask Wikipedia";
		else return "Seriously?";
	}

	@Override
	public String getFarewell() {
		double rand = Math.random();
		if (rand < 0.33) return "Great, good riddance";
		else if (rand < 0.67) return "Don't come back soon, okay?";
		else return "Get lost";
	}

	@Override
	public String getOther() {
		double rand = Math.random();
		if (rand < 0.33) return "Man, when they say users are getting dumber, I mean, really.";
		else if (rand < 0.67) return "You're not the dumbest person on the planet, but you'd better hope he doesn't die";
		else return "Everybody makes mistakes; some people *are* mistakes.";
	}

}
