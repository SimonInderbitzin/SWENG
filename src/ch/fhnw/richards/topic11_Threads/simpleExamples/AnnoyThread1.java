package ch.fhnw.richards.topic11_Threads.simpleExamples;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class AnnoyThread1 extends Thread {
	private Annoy1 parent;
	private volatile boolean stop;
	private Color color = Color.WHITE;

	public AnnoyThread1(Annoy1 parent, String name) {
		super(name);
		this.parent = parent;
		this.stop = false;
	}

	public void pleaseStop() {
		stop = true;
	}

	public void run() {
		Node root = parent.getRoot();
		while (!stop) {
			if (color.equals(Color.WHITE)) {
				color = Color.BLACK;
				root.setStyle("-fx-background-color: BLACK");
			} else {
				color = Color.WHITE;
				root.setStyle("-fx-background-color: WHITE");
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
}
