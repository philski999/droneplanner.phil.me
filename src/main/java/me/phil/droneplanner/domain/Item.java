package me.phil.droneplanner.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Item {
	public static Item newInstance(ProductType type) {
		return new Item(type);
	}

	@PlanningVariable(valueRangeProviderRefs= {"orders"}, nullable=true)
	public Order getAssignedOrder() {
		return order;
	}

	public void setAssignedOrder(Order order) {
		this.order = order;
	}
	
	private ProductType type ;
	private double serialNumber;	// Identifies the item
	private Order order;			// The order that the item has been assigned to
	
	private Item(ProductType type) {
		this.type = type;
		serialNumber = Math.random();
	}
}
