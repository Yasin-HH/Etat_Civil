package model;
import java.time.LocalDate;

public class Citizen {

	private int citizenID;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirthDate;
	private String sex;
	private MartialStatus martialStatus;
	private int spouseIDNumber;
	
	public Citizen() {
	}

	public Citizen(int citizenID, String firstName, String lastName, LocalDate dateOfBirthDate, String sex,
			MartialStatus martialStatus, int spouseIDNumber) {
		this.citizenID = citizenID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirthDate = dateOfBirthDate;
		this.sex = sex;
		this.martialStatus = martialStatus;
		this.spouseIDNumber = spouseIDNumber;
	}

	public int getCitizenID() {
		return citizenID;
	}

	public void setCitizenID(int citizenID) {
		this.citizenID = citizenID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirthDate() {
		return dateOfBirthDate;
	}

	public void setDateOfBirthDate(LocalDate dateOfBirthDate) {
		this.dateOfBirthDate = dateOfBirthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public MartialStatus getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(MartialStatus martialStatus) {
		this.martialStatus = martialStatus;
	}

	public int getSpouseIDNumber() {
		return spouseIDNumber;
	}

	public void setSpouseIDNumber(int spouseIDNumber) {
		this.spouseIDNumber = spouseIDNumber;
	}

	
	
	
	
}
