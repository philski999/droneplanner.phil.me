package me.phil.droneplanner.domain;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

// Planning fact
public class Order {
	public static Order newInstance(Location deliveryLocation, Map<ProductType, Integer> orderItems) {
		return new Order(deliveryLocation, orderItems);
	}
	
	public Map<ProductType, Integer> getLineItems() {
		return Maps.newHashMap(lineItems);
	}
	
	private Map<ProductType, Integer> lineItems = Maps.newHashMap();
	private Location deliveryLocation;

	private Order(Location deliveryLocation, Map<ProductType, Integer> lineItems) {
		this.deliveryLocation = Location.newInstance(deliveryLocation);
		for (Entry<ProductType, Integer> e : lineItems.entrySet()) {
			this.lineItems.put(e.getKey(), new Integer(e.getValue()));
		}
	}
}


