package com.erernst.jets;

import java.util.Scanner;

public class Barracks {
	private Pilot[] roster = rosterGen();

	public static Pilot[] rosterGen() {
		Pilot[] roster = new Pilot[5];
		int x = (int) (5 * Math.random());
		roster[x] = new Pilot("Jim Preston", 35, 7);
		int y = x;
		while (x == y) {
			y = (int) (5 * Math.random());
			y = (y != x ? y : (int) (5 * Math.random()));
		}
		roster[y] = new Pilot("Sara Calfor", 41, 17);
		int z = x;
		while (x == z || y == z) {
			z = (int) (5 * Math.random());
			z = (z != x && z != y ? z : (int) (5 * Math.random()));
		}
		roster[z] = new Pilot("Herb Puma", 26, 1);
		int u = x;
		while (u == z || u == x || u == y) {
			u = (int) (5 * Math.random());
			u = (u != x && u != y && u != z ? u : (int) (5 * Math.random()));
		}
		roster[u] = new Pilot("Sally Johnson", 56, 31);
		int v = x;
		while (v == u || v == x || v == y || v == z) {
			v = (int) (5 * Math.random());
			v = (v != x && v != y && v != z && v != u ? v : (int) (5 * Math.random()));
		}
		roster[v] = new Pilot("Bernard Thompson", 45, 20);
		return roster;

	}

	static Pilot[] addPilot(Scanner keyb, Pilot[] roster) {
		Pilot[] temp = new Pilot[roster.length + 1];
		for (int i = 0; i < roster.length; i++) {
			temp[i] = roster[i];
		}
		System.out.print("Pilot Name: ");
		String a = keyb.nextLine();
		String name = keyb.nextLine();
		System.out.print("Age (years): ");
		int age = (int) JetRun.getDouble(keyb);
		System.out.print("Experience (years): ");
		int experience = (int) JetRun.getDouble(keyb);
		int x = (int) (roster.length * Math.random());
		temp[temp.length - 1] = roster[x];
		temp[x] = new Pilot(name, age, experience);
		return temp;
	}
}
