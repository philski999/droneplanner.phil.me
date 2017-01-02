package me.phil.droneplanner.domain;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class Warehouse {
	public static Warehouse newInstance(Location l) {
		return new Warehouse(l);
	}
	
	public void stockItems(Map<ProductType, Integer> itemsToStock) {
		for (Entry<ProductType, Integer> e : itemsToStock.entrySet()) {
			Integer newStockLevel = itemsInStock.getOrDefault(e.getKey(), 0) + e.getValue();
			itemsInStock.put(e.getKey(), newStockLevel);
		}
	}
	
	// Provide as many of the requested items as are in stock.
	// Returns a map of the items that are actually provided.
	public Map<ProductType, Integer> provideItems(Map<ProductType, Integer> itemsToProvide) {
		Map<ProductType, Integer> providedItems = Maps.newHashMap();
		for (Entry<ProductType, Integer> e : itemsToProvide.entrySet()) {
			Integer stockLevel = itemsInStock.getOrDefault(e.getKey(), 0);
			Integer countOfItemsToProvide = Math.min(e.getValue(), stockLevel);
			providedItems.put(e.getKey(), countOfItemsToProvide);
			itemsInStock.put(e.getKey(), stockLevel - countOfItemsToProvide);
		}
		
		return providedItems;
	}

	private Map<ProductType, Integer> itemsInStock = Maps.newHashMap();
	private Location location;

	private Warehouse(Location l) {
		this.location = Location.newInstance(l);
	}
}
