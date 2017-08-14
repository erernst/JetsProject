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
		builder.append("Speed: ");
		builder.append(speed);
		builder.append("Range: ");
		builder.append(range);
		builder.append("Price: ");
		builder.append(price);
		return builder.toString();
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
	

}
