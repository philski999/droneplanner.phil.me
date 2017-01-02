package me.phil.droneplanner.domain;

public class DeliveryMap {
	public static DeliveryMap newInstance(int rows, int columns) {
		return new DeliveryMap(rows, columns);
	}
	
	public static DeliveryMap newInstance() {
		return newInstance(10, 10);
	}
	
	private int rows;
	private int columns;
	
	private DeliveryMap(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
}
