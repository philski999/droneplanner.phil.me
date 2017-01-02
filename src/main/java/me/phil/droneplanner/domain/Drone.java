package me.phil.droneplanner.domain;

public class Drone {
	public static Drone newInstance(int maxPayloadWeight) {
		return new Drone(maxPayloadWeight);
	}
	
	private int maxPayloadWeight;
	
	private Drone(int maxPayloadWeight) {
		this.maxPayloadWeight = maxPayloadWeight;
	}
}
