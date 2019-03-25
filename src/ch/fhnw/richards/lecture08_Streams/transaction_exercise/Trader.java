package ch.fhnw.richards.lecture08_Streams.transaction_exercise;

public class Trader {
	
	private final String name;
	private       String city;

	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String newCity){
		this.city = newCity;
	}

	public String toString(){
		return "Trader:" + this.name + " in " + this.city;
	}
}