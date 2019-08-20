package ch.fhnw.richards.topic04_ClassDesign.identityExamples;

public class MyClassInt implements Comparable<MyClassInt> {
	private final int idAttr;

	public MyClassInt(int idAttr) {
		this.idAttr = idAttr;
	}

	@Override
	public int compareTo(MyClassInt o) {
		return Integer.compare(this.idAttr, o.idAttr);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) return false;
		MyClassInt other = (MyClassInt) obj;
		return idAttr == other.idAttr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAttr;
		return result;
	}
}
