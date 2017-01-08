package me.phil.droneplanner.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Sets;

public class Warehouse {
	public static Warehouse newInstance(Location l) {
		return new Warehouse(l);
	}
	
	public void stockItems(Map<ProductType, Integer> itemsToStock) {
		for (Entry<ProductType, Integer> e : itemsToStock.entrySet()) {
			for (int i = 0; i < e.getValue(); i++) {
				Item item = Item.newInstance(e.getKey());
				itemsInStock.add(item);
			}
		}
	}
	
	private Set<Item> itemsInStock = Sets.newHashSet();
	private Location location;

	private Warehouse(Location l) {
		this.location = Location.newInstance(l);
	}

	public Collection<? extends Item> itemsInWarehouse() {
		return itemsInStock;
	}
}
