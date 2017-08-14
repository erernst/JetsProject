package com.erernst.jets;

public class Pilot {
	private String name;
	private int age, experience;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pilot(String name, int age, int experience) {
		this.name = name;
		this.age = age;
		this.experience = experience;
	}
	public Pilot() {
		this("name", 35, 35);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" Age: ");
		builder.append(age);
		builder.append(" Experience: ");
		builder.append(experience);
		return builder.toString();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
}
