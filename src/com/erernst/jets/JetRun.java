package com.erernst.jets;

import java.util.Scanner;

public class JetRun {
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		int choice = 1;
		Choice: while (choice !=5) {
			choice = menu(keyb);

			switch (choice) {
			case 1:
				// listFleet();
				continue Choice;
			case 2:
				// viewFastest();
				continue Choice;
			case 3:
				// viewLongestRange();
				continue Choice;
			case 4:
				// addJet();
				continue Choice;
			case 5:
				break;
			default:
				System.err.println("Invalid Entry.");
				continue Choice;
			}
		}
	}

	public static int menu(Scanner keyb) {

		System.out.println("[1] List fleet");
		System.out.println("[2] View fastest jet");
		System.out.println("[3] View jet with longest range");
		System.out.println("[4] Adda jet to fleet");
		System.out.println("[5] Quit");
		return keyb.nextInt();

	}
}
