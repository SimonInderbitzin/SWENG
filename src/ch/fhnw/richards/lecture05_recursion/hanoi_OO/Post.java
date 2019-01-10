package ch.fhnw.richards.lecture05_recursion.hanoi_OO;

public final class Post extends Base {
	private final String name;

	public Post(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Post " + name;
	}

	// --- Getters and Setters ---

	public String getName() {
		return name;
	}
}
