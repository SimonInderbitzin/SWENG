package ch.fhnw.richards.xtra01_InductionRecursion.hanoi_OO;

/**
 * Both disks and posts can have a disk on top of them. For a post, this is the
 * bottom disk in a stack. For a disk, this is the next disk in the stack.
 * Hence, the attribute, getter and setter are defined in this common
 * superclass.
 */
public abstract class Base {
	private Disk onTop = null;

	public Disk getOnTop() {
		return onTop;
	}

	public void setOnTop(Disk onTop) throws Exception {
		// Can only place disks, and only if onTop is not occupied
		if (this.onTop == null || onTop == null) {
			this.onTop = onTop;
		} else {
			throw new Exception(this.toString() + " is already occupied");
		}
	}
}
