package com.erernst.jets;

import java.util.Scanner;

public class JetRun {
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		String choice = "1";
		Pilot[] roster = Barracks.rosterGen();
		Jet[] fleet = new Jet[5];
		fleet = Hangar.initializeFleet(fleet, roster);
		Choice: while (!choice.equals("5")) {
			choice = menu(keyb);

			switch (choice) {
			case "1":
				Hangar.listFleet(fleet);
				System.out.println("");
				continue Choice;
			case "2":
				viewFastest(fleet);
				System.out.println("");
				continue Choice;
			case "3":
				viewLongestRange(fleet);
				System.out.println("");
				continue Choice;
			case "4":
				if (roster.length < fleet.length + 1) {
					System.out.println("Short pilots, hire a pilot:");
					roster = Barracks.addPilot(keyb, roster);
				}
				fleet = Hangar.addJet(keyb, fleet, roster);
				System.out.println("");
				continue Choice;
			case "5":
				break;
			case "6":
				roster = Barracks.addPilot(keyb, roster);
				System.out.println("");
				continue Choice;
			default:
				System.err.println("Invalid Entry.");
				continue Choice;
			}
		}
	}



	public static String menu(Scanner keyb) {

		System.out.println("[1] List fleet");
		System.out.println("[2] View fastest jet");
		System.out.println("[3] View jet with longest range");
		System.out.println("[4] Add a jet to fleet");
		System.out.println("[5] Quit");
		System.out.println("[6] Hire pilot");
		return keyb.next();

	}





	static void viewFastest(Jet[] fleet) {
		double maxSpeed = 0;
		for (int i = 0; i < fleet.length; i++) {
			maxSpeed = (fleet[i].getSpeed() > maxSpeed ? fleet[i].getSpeed() : maxSpeed);
		}
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i].getSpeed() == maxSpeed) {
				System.out.println(fleet[i]);
			}
		}
		return;
	}

	static void viewLongestRange(Jet[] fleet) {
		double maxRange = 0;
		for (int i = 0; i < fleet.length; i++) {
			maxRange = (fleet[i].getRange() > maxRange ? fleet[i].getRange() : maxRange);
		}
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i].getRange() == maxRange) {
				System.out.println(fleet[i]);
			}
		}
		return;
	}

	static double getDouble(Scanner keyb) {
		double temp = 0;
		while (!keyb.hasNextDouble()) {

			System.out.print("Invalid Entry. Use numbers only: "); // notifies user of invalid entry
			keyb.next();
		}

		temp = keyb.nextDouble();
		if (temp < 0) {
			System.err.print("Invalid Entry. Please make a valid entry:");
			temp = getDouble(keyb);
		}
		return temp;
	}

}
