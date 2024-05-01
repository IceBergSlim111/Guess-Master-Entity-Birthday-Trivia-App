// Erhowvosere Otubu
// 20203052
// 2023-04-10

package com.example.guessmaster;

public class Country extends Entity{
	private final String capital;
	
	public Country(String name, Date birthDate, String capital, double difficulty) {
		super(name, birthDate, difficulty);
		this.capital = capital;
	}
	
	public Country(Country entity) {
		super(entity.getName(), entity.getBorn(), entity.getDifficulty());
		this.capital = entity.getCapital();
	}

	public String getCapital() { //accessor method to get the capital of the country
		return capital;
	}
	
	public Entity clone(Entity entity) { //copy constructor using the clone method
		return new Country(this);
	}

	public String toString() {
		return super.toString() + "Capital: " +capital +"\n";
	}
	
	public String entityType() { //entityType method
		return "This entity is a Country!";
	}
}
