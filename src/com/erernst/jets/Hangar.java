package com.erernst.jets;

import java.util.Scanner;

public class Hangar {
	static Jet[] initializeFleet(Jet[] fleet, Pilot[] roster) {

		fleet[0] = new Jet("F-35A Lightning II", Jet.convertToMach(1200.0), 1350.0, 94_600_000.0, 1, roster[0]);
		fleet[1] = new Jet("F-22A Raptor", Jet.convertToMach(1200.0), 1850.0, 143_000_000.0, 1, roster[1]);
		fleet[2] = new Jet("F-16 Fighting Falcon", Jet.convertToMach(1500.0), 2002.0, 14_600_000.0, 3, roster[2]);
		fleet[3] = new Jet("B-1B Lancer", Jet.convertToMach(900.0), 2000.0, 317_000_000.0, 4, roster[3]);
		fleet[4] = new Jet("E-3 Sentry", Jet.convertToMach(360.0), 5000.0, 270_000_000.0, 23, roster[4]);
		return fleet;
	}
	static void listFleet(Jet[] fleet) {
		for (int i = 0; i < fleet.length; i++) {
			System.out.println(fleet[i]);
		}
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
	static Jet[] addJet(Scanner keyb, Jet[] fleet, Pilot[] roster) {
		System.out.println("Plane");
		System.out.print("Model: ");
		String a = keyb.nextLine();
		String model = keyb.nextLine();
		System.out.print("Speed (mph): ");
		double speedTemp = JetRun.getDouble(keyb);
		double speed = Jet.convertToMach(speedTemp);
		System.out.print("Range (miles): ");
		double range = JetRun.getDouble(keyb);
		System.out.print("Price: $");
		double price = JetRun.getDouble(keyb);
		System.out.print("Capacity: ");
		int capacity = (int) JetRun.getDouble(keyb);

		Jet[] temp = new Jet[fleet.length + 1];
		for (int i = 0; i < fleet.length; i++) {
			temp[i] = new Jet(fleet[i].getModel(), fleet[i].getSpeed(), fleet[i].getRange(), fleet[i].getPrice(),
					fleet[i].getCapacity(), roster[i]);
		}
		temp[temp.length - 1] = new Jet(model, speed, range, price, capacity, roster[roster.length - 1]);

		return temp;
	}

}
