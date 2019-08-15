package ch.fhnw.richards.topic02_JavaFX.petExample.v2;

import ch.fhnw.richards.topic02_JavaFX.petExample.Pet;

public class PetModel {
	private Pet currentPet;
	
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		currentPet = new Pet(species, gender, name);
	}
	
	public void deletePet() {
		currentPet = null;
	}
	
	public Pet getPet() {
		return currentPet;
	}
}
