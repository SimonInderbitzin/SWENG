package ch.fhnw.richards.topic02_JavaFX.petExample.v3;

import ch.fhnw.richards.topic02_JavaFX.petExample.Pet;
import javafx.beans.property.SimpleObjectProperty;

public class PetModel {
	private final SimpleObjectProperty<Pet> petProperty = new SimpleObjectProperty<>();
	
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		petProperty.set(new Pet(species, gender, name));
	}
	
	public void deletePet() {
		petProperty.set(null);
	}
	
	public Pet getPet() {
		return petProperty.get();
	}
	
	public SimpleObjectProperty<Pet> petProperty() {
		return petProperty;
	}
}
