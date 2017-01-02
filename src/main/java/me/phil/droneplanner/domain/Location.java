package me.phil.droneplanner.domain;

public class Location {
	public static Location newInstance(int row, int column) {
		return new Location(row, column);
	}

	public static Location newInstance(Location l) {
		return newInstance(l.row, l.column);
	}
	
	private Location(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	private int row;
	private int column;
}
