// Erhowvosere Otubu
// 20293052
// 2023-04-10

package com.example.guessmaster;

public class Person extends Entity{
	private final String gender;
	
	public Person(String name, Date birthDate, String gender, double difficulty) {
		super(name, birthDate, difficulty);
		this.gender = gender;
	}
	
	public Person(Person entity) {
		super(entity.getName(), entity.getBorn(), entity.getDifficulty());
		this.gender = entity.getGender();
	}
	
	public String getGender() { //accessor method that returns the gender of the person
		return gender;
	}

	public Entity clone(Entity entity) { // copy constructor using the clone method
		return new Person(this);
	}

	public String toString() {
		return super.toString() + "Gender: " + gender +"\n";
	}
	
	public String entityType() { // entityType method
		return "This entity is a person!";
	}
}
