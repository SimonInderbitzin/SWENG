package ch.fhnw.richards.topic07_Streams.painter_example;

public enum CountryCode {
	AT("Austria"),
	CH("Switzerland"),
	DE("Germany"),
	ES("Spain"),
	FR("France"),
	IT("Italy"),
	NL("Netherlands"),
	NO("Norway"),
	US("United States");
	
	private String name;
	
	private CountryCode(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
