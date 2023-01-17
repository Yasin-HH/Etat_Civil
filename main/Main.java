package main;

import frames.MainFrame;
import model.TownHall;

public class Main {

	public static void main(String[] args) {

		TownHall townHall = new TownHall();
		townHall.loadDummyData();
		
		MainFrame main = new MainFrame(townHall);
		main.setVisible(true);
		
	}

}
