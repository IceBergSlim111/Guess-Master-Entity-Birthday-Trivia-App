// Erhowvosere Otubu
// 20293052
// 2023-04-10

package com.example.guessmaster;

abstract class Entity {
	private final String name;
	private final Date born;
	private final double difficulty; // used to keep the difficulty of guessing an entity
	
	public Entity(String name, Date birthDate, double difficulty) {
		this.name = name;
		this.born = new Date(birthDate); // no privacy leak
		this.difficulty = difficulty;
	}
	
	public Entity(Entity entity) { // copy constructor
		this.name = entity.name;
		this.born = new Date(entity.born);
		this.difficulty = entity.getDifficulty();
	}

	abstract String entityType();

	public abstract Entity clone(Entity entity);

	public String getName() {
		return name;
	}

	public Date getBorn() {
		return new Date(born);
	}

	public String toString() {  // proper toString method
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}

	public double getDifficulty() {
		return difficulty;
	}

	public int getAwardTicketNumber(){
		/*
		public method that returns the number of tickets
		if a user correctly guesses an entity's birth date
		 */
		Integer ticketNumber = (int)(difficulty*100);
		return ticketNumber;
	}

	public String welcomeMessage() { // method that returns a string of welcome message
		return "Welcome! Let's start the game! " + entityType();
	}

	public void closingMessage() {
		/*
		method that returns a string of closing message for each round of correct guess
		 */
		System.out.println("Congratulations! " +
				"The detailed information of the entity you guessed is:\n" + toString());
	}
}
