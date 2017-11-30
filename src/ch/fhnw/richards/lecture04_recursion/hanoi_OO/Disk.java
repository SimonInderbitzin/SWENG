package ch.fhnw.richards.lecture04_recursion.hanoi_OO;

/**
 * A disk has a size, and can have another (smaller) disk on top of itself.
 * 
 * @author brad
 *
 */
public final class Disk extends Base {
	private final int size;

	public Disk(int size) {
		this.size = size;
	}

	// --- Getters and Setters ---

	@Override
	public void setOnTop(Disk onTop) throws Exception {
		if (onTop != null && onTop.size >= this.size) {
			throw new Exception(onTop.toString() + " cannot be set on " + this.toString());
		} else {
			super.setOnTop(onTop);
		}
	}

	public String toString() {
		return "Disk " + size;
	}

	// --- Getters and Setters ---

	public int getSize() {
		return size;
	}
}
