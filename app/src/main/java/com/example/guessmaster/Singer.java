// Erhowvosere Otubu
// 20293052
// 2023-04-10

package com.example.guessmaster;

public class Singer extends Person {
	private final String debutAlbum; // holds the title of the debut album
	private final Date debutAlbumReleaseDate; // saves the date when the debut album was released
	
	public Singer(String name, Date birthDate, String gender, String debutAlbum,
				  Date debutAlbumReleaseDate, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}
	
	public Singer(Singer singer) {
		super(singer.getName(), singer.getBorn(), singer.getGender(), singer.getDifficulty());
		this.debutAlbum = singer.getDebutAlbum();
		this.debutAlbumReleaseDate = singer.getDebutAlbumDate();
	}

	public String getDebutAlbum() { //accessor method that returns the name of the debut album of the singer
		return debutAlbum;
	}
	
	public Date getDebutAlbumDate() { //accessor method that returns the debut album release date for the singer
		return debutAlbumReleaseDate;
	}

	public Singer clone(Singer entity) { // copy constructor using the clone method
		return new Singer(this);
	}

	public String toString() {
		return super.toString() + "Debut album: " + debutAlbum +"\n" +
				"Release date: " + debutAlbumReleaseDate + "\n";
	}
	
	public String entityType() { //entityType
		return "This entity is a singer!";
	}
}
