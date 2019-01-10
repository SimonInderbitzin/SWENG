package ch.fhnw.richards.lecture03_DesignPatterns.strategyChatBot;

import java.util.Scanner;

public class ChatBot {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What kind of conversation do you want to have? Insulting or Friendly?");
		String answer = in.nextLine();
		
		// Create chat bot
		
		ChatBot bot = new ChatBot();
		// Implant desired personality
		if (answer.toUpperCase().charAt(0) == 'F') {
			bot.setPersonality(new Friendly());
		} else {
			bot.setPersonality(new Insulting());
		}
		
		// Run bot
		InputType classification;
		System.out.println(bot.getGreeting());
		do {
			String input = in.nextLine();
			 classification = bot.classifyInput(input);
			System.out.println(bot.reply(classification, input));
		} while (classification != InputType.FAREWELL);
		
		in.close();
	}

	//-------- ChatBot implementation -------
	private enum InputType { GREETING, QUESTION, UNKNOWN, FAREWELL; };
	
	private Personality personality;
	
	public void setPersonality(Personality personality) {
		this.personality = personality;
	}
	
	public String getGreeting() {
		return personality.getGreeting();
	}

	public String reply(InputType type, String input) {
		switch (type) {
		case GREETING:
			return personality.getGreeting();
		case QUESTION:
			return personality.answerQuestion();
		case FAREWELL:
			return personality.getFarewell();
		default:
			return personality.getOther();
		}
	}

	public InputType classifyInput(String input) {
		input = input.toLowerCase();
		if (input.contains("hello") || input.contains("hi")) return InputType.GREETING;
		if (input.contains("bye")) return InputType.FAREWELL;
		if (input.contains("?")) return InputType.QUESTION;
		return InputType.UNKNOWN;
	}
}
