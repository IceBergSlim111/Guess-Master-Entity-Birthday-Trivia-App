// Erhowvosere Otubu
// 20293052
// 2023-04-10

package com.example.guessmaster;

public class Politician extends Person {
	private final String party; // saves the political party of the politician
	
	public Politician(String name, Date birthDate, String gender, String party, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.party = party;
	}
	
	public Politician(Politician politician) {
		super(politician.getName(), politician.getBorn(),
				politician.getGender(), politician.getDifficulty());
		this.party = politician.getParty();
	}

	public String getParty() { //accessor method that returns the political party of the politician
		return party;
	}
	
	public Politician clone() { //copy constructor using the clone method
		return new Politician(this);
	}
	
	public String toString() {
		return super.toString() + "Political party: " + party +"\n";
	}
	
	public String entityType() { //entityType
		return "This entity is a politician!";
	}
}
