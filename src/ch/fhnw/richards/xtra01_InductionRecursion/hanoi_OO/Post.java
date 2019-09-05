package ch.fhnw.richards.xtra01_InductionRecursion.hanoi_OO;

public final class Post extends Base {
	private final String name;

	public Post(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Post " + name;
	}

	public String getName() {
		return name;
	}
}
