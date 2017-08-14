package com.erernst.jets;

import java.util.Scanner;

public class JetRun {
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		String choice = "1";
		Pilot[] roster = Barracks.rosterGen();
		Jet[] fleet = new Jet[5];
		fleet = initializeFleet(fleet, roster);
		Choice: while (!choice.equals("5")) {
			choice = menu(keyb);

			switch (choice) {
			case "1":
				listFleet(fleet);
				continue Choice;
			case "2":
				viewFastest(fleet);
				continue Choice;
			case "3":
				viewLongestRange(fleet);
				continue Choice;
			case "4":
				if (roster.length < fleet.length + 1) {
					System.out.println("Short pilots, hire a pilot:");
					roster = Barracks.addPilot(keyb, roster);
				}
				fleet = addJet(keyb, fleet, roster);
				continue Choice;
			case "5":
				break;
			case "6":
				roster = Barracks.addPilot(keyb, roster);
				continue Choice;
			default:
				System.err.println("Invalid Entry.");
				continue Choice;
			}
		}
	}

	static Jet[] initializeFleet(Jet[] fleet, Pilot[] roster) {

		fleet[0] = new Jet("F-35A Lightning II", Jet.convertToMach(1200.0), 1350.0, 94_600_000.0, 1, roster[0]);
		fleet[1] = new Jet("F-22A Raptor", Jet.convertToMach(1200.0), 1850.0, 143_000_000.0, 1, roster[1]);
		fleet[2] = new Jet("F-16 Fighting Falcon", Jet.convertToMach(1500.0), 2002.0, 14_600_000.0, 3, roster[2]);
		fleet[3] = new Jet("B-1B Lancer", Jet.convertToMach(900.0), 2000.0, 317_000_000.0, 4, roster[3]);
		fleet[4] = new Jet("E-3 Sentry", Jet.convertToMach(360.0), 5000.0, 270_000_000.0, 23, roster[4]);
		return fleet;
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

	static void listFleet(Jet[] fleet) {
		for (int i = 0; i < fleet.length; i++) {
			System.out.println(fleet[i]);
		}
	}

	static Jet[] addJet(Scanner keyb, Jet[] fleet, Pilot[] roster) {
		System.out.print("Model: ");
		String a = keyb.nextLine();
		String model = keyb.nextLine();
		System.out.print("Speed (mph): ");
		double speedTemp = getDouble(keyb);
		double speed = Jet.convertToMach(speedTemp);
		System.out.print("Range (miles): ");
		double range = getDouble(keyb);
		System.out.print("Price: $");
		double price = getDouble(keyb);
		System.out.print("Capacity: ");
		int capacity = (int) getDouble(keyb);

		Jet[] temp = new Jet[fleet.length + 1];
		for (int i = 0; i < fleet.length; i++) {
			temp[i] = new Jet(fleet[i].getModel(), fleet[i].getSpeed(), fleet[i].getRange(), fleet[i].getPrice(),
					fleet[i].getCapacity(), roster[i]);
		}
		temp[temp.length - 1] = new Jet(model, speed, range, price, capacity, roster[roster.length - 1]);

		return temp;
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
