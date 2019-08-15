package ch.fhnw.richards.topic02_JavaFX.petExample.v0;

public class PetController {
	private PetView view;
	private PetModel model;

	public PetController(PetModel model, PetView view) {
		this.model = model;
		this.view = view;
	}
}
