package me.phil.droneplanner.domain;

public class DeliveryMap {
	public static DeliveryMap newInstance(int rows, int columns) {
		return new DeliveryMap(rows, columns);
	}
	
	private int rows;
	private int columns;
	
	private DeliveryMap(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
}
