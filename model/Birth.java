package model;

import java.time.LocalDate;

public class Birth {

	private int person1ID;
	private int person2ID;
	private LocalDate birthDate;

	public Birth() {
	}

	public Birth(int person1id, int person2id, LocalDate birthDate) {
		person1ID = person1id;
		person2ID = person2id;
		this.birthDate = birthDate;
	}

	public int getPerson1ID() {
		return person1ID;
	}

	public void setPerson1ID(int person1id) {
		person1ID = person1id;
	}

	public int getPerson2ID() {
		return person2ID;
	}

	public void setPerson2ID(int person2id) {
		person2ID = person2id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
