package ch.fhnw.richards.lecture12_Threads.simpleExamples;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class AnnoyLabel2 extends Label implements Runnable {
	String name;
	Thread thread;
	volatile boolean stopThread;
	int sleepTime;
	private Color color = Color.WHITE;
	
	AnnoyLabel2(String name, int sleepTime) {
		super();
		this.name = name;
		this.sleepTime = sleepTime;
	}
	
	@Override
	public void run() {
		while (!stopThread) {
			if (color.equals(Color.WHITE)) {
				color = Color.BLACK;
				this.setStyle("-fx-background-color: BLACK");
			} else {
				color = Color.WHITE;
				this.setStyle("-fx-background-color: WHITE");
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
			}
		}
	}

	boolean isAlive() {
		if (thread == null) {
			return false;
		} else {
			return thread.isAlive();
		}
	}
	
	void start() {
		thread = new Thread(this, name);
		stopThread = false;
		System.out.println("starting thread " + name);
		thread.start();
	}
	
	void stop() {
		stopThread = true;
		thread.interrupt();
	}
}
