package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TownHall {

	private List<Citizen> citizensList;
	private List<Marriage> marriagesList;
	private List<Birth> birthsList;

	public TownHall() {
		citizensList = new ArrayList<Citizen>();
		marriagesList = new ArrayList<Marriage>();
		birthsList = new ArrayList<Birth>();
	}

	public void loadDummyData() {

		citizensList
				.add(new Citizen(1, "John", "Michle", LocalDate.parse("1990-12-07"), "Male", MartialStatus.single, -1));
		citizensList.add(
				new Citizen(2, "Eva", "Emma", LocalDate.parse("1992-05-02"), "Female", MartialStatus.divorced, -1));
		citizensList
				.add(new Citizen(3, "Lucas", "James", LocalDate.parse("1993-04-01"), "Male", MartialStatus.married, 4));
		citizensList.add(new Citizen(4, "Amelia", "Charlotte", LocalDate.parse("1995-12-09"), "Female",
				MartialStatus.married, 3));
		
		marriagesList.add(new Marriage(3,4));
	}

	public Citizen getPerson(int pid) {

		for (Citizen citizen : citizensList) {
			if (citizen.getCitizenID() == pid)
				return citizen;
		}

		return null;
	}

	public void addMarriage(int p1id, int p2id) {
		updateMartialStatus(p1id, MartialStatus.married);
		updateMartialStatus(p2id, MartialStatus.married);
		updateSpouseID(p1id, p2id);
		updateSpouseID(p2id, p1id);
		addMarriageToList(p1id, p2id);
	}

	private void addMarriageToList(int p1id, int p2id) {
		marriagesList.add(new Marriage(p1id, p2id));
	}

	private void removeMarriageFromList(int pid) {
		for (Marriage marriage : marriagesList) {
			if (marriage.getPerson1() == pid || marriage.getPerson2() == pid) {
				marriagesList.remove(marriage);
				break;
			}
		}
	}

	private void updateSpouseID(int p1id, int p2id) {
		for (Citizen citizen : citizensList) {
			if (citizen.getCitizenID() == p1id)
				citizen.setSpouseIDNumber(p2id);
		}

	}

	private void updateMartialStatus(int pid, MartialStatus status) {
		for (Citizen citizen : citizensList) {
			if (citizen.getCitizenID() == pid)
				citizen.setMartialStatus(status);
		}
	}

	public void setDivorce(int pID) {
		Citizen p = getPerson(pID);
		int p2ID = p.getSpouseIDNumber();
		updateMartialStatus(pID, MartialStatus.divorced);
		updateMartialStatus(p2ID, MartialStatus.divorced);
		updateSpouseID(pID, -1);
		updateSpouseID(p2ID, -1);
		removeMarriageFromList(pID);
	}

	public void addBirth(Citizen p1, LocalDate date) {
		birthsList.add(new Birth(p1.getCitizenID(), p1.getSpouseIDNumber(), date));
	}

	public List<Citizen> getPersonsList() {
		return citizensList;
	}

	public void addCitizen(Citizen citizen) {
		citizensList.add(citizen);
	}

	public void saveDataToFile() {
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("CitizensList.txt"));
			
			for (Citizen c : citizensList) {
				bw.write(c.getCitizenID()+"");
				bw.write(" -- ");
				bw.write(c.getLastName());
				bw.write(" -- ");
				bw.write(c.getFirstName());
				bw.write(" -- ");
				bw.write(c.getSex());
				bw.write(" -- ");
				bw.write(c.getDateOfBirthDate().toString());
				bw.write(" -- ");
				bw.write(c.getMartialStatus().toString());
				bw.write(" -- ");
				bw.write(c.getSpouseIDNumber()+"");
				bw.newLine();
			}
			
			bw.close();
			
			bw = new BufferedWriter(new FileWriter("MarriagesList.txt"));
			
			for (Marriage m : marriagesList) {
				bw.write(m.getPerson1()+"");
				bw.write(" -- ");
				bw.write(m.getPerson2()+"");
				bw.newLine();
			}
			
			bw.close();
			
			bw = new BufferedWriter(new FileWriter("BirthsList.txt"));
			
			for (Birth b : birthsList) {
				bw.write(b.getPerson1ID()+"");
				bw.write(" -- ");
				bw.write(b.getPerson2ID()+"");
				bw.write(" -- ");
				bw.write(b.getBirthDate().toString());
				bw.newLine();
			}
			
			bw.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
