package ch.fhnw.richards.topic04_ClassDesign.identityExamples;

/**
 * This class uses a String as an identity attribute. We implement .equals,
 * .compareTo and .hashCode methods.
 */
public class MyClassString implements Comparable<MyClassString> {
	private final String idAttr;

	public MyClassString(String idAttr) {
		this.idAttr = idAttr;
	}

	@Override
	public int compareTo(MyClassString o) {
		return idAttr.compareTo(o.idAttr);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) return false;
		MyClassString other = (MyClassString) obj;
		if (idAttr == null)
			return (other.idAttr == null);
		else
			return (idAttr.equals(other.idAttr));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAttr == null) ? 0 : idAttr.hashCode());
		return result;
	}
}
