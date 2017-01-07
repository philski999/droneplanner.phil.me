package me.phil.droneplanner.domain;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class Order {
	public static Order newInstance(Location deliveryLocation, Map<ProductType, Integer> orderItems) {
		return new Order(deliveryLocation, orderItems);
	}
	
	private Map<ProductType, Integer> orderItems = Maps.newHashMap();
	private Location deliveryLocation;

	public Order(Location deliveryLocation,	Map<ProductType, Integer> orderItems) {
		this.deliveryLocation = Location.newInstance(deliveryLocation);
		for (Entry<ProductType, Integer> e : orderItems.entrySet()) {
			this.orderItems.put(e.getKey(), new Integer(e.getValue()));
		}
	}

	// 
	public int getScore() {
		// TODO
		// Should return a positive value if the order has been fulfilled.
		// Higher scores are given for earlier fulfilment
		return 0;
	}
}


