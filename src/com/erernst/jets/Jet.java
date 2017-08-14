package com.erernst.jets;

public class Jet {
	private String model;
	private Double speed, range, price;
	private int capacity;
	private Pilot pilot;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Model: ");
		builder.append(model);
		builder.append(" Speed: ");
		builder.append(speed);
		builder.append(" mach Range: ");
		builder.append(range);
		builder.append(" miles Price: $");
		builder.append((int)(price/1000000));
		builder.append(" M \nPilot: ");
		builder.append(pilot);
		return builder.toString();
	}
	public Jet(String model2, double speed2, double range2, double price2, int capacity2) {
		this();
	}
	public Jet(String model, Double speed, Double range, Double price, int capacity, Pilot pilot) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.capacity = capacity;
		this.pilot = pilot;
	}
	public Jet() {
		super();
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getRange() {
		return range;
	}
	public void setRange(Double range) {
		this.range = range;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	static double convertToMach(double speedTemp) {
		double speed = 0.00134935* speedTemp;
		return speed;
	}

}
