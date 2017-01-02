package me.phil.droneplanner.domain;

// A type of product that can be fulfilled. Product types are immutable.
public class ProductType {
	public static ProductType newInstance(int weight) {
		return new ProductType(weight);
	}

	private int itemWeight;
	
	private ProductType(int weight) {
		this.itemWeight = weight;
	}
}
