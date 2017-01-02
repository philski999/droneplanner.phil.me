package me.phil.droneplanner.domain;

public class Item {
	public static Item newInstance(ProductType type) {
		return new Item(type);
	}
	
	private ProductType type ;
	
	private Item(ProductType type) {
		this.type = type;
	}
}
