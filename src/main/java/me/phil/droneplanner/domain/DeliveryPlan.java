package me.phil.droneplanner.domain;

import java.util.Collection;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import com.google.common.collect.Lists;

@PlanningSolution
public class DeliveryPlan implements Solution<HardSoftScore> {
	public static DeliveryPlan newInstance() {
		return new DeliveryPlan();
	}
	
	private HardSoftScore score;

	private DeliveryMap deliveryMap = DeliveryMap.newInstance();
	private List<Drone> drones = Lists.newArrayList();
	private List<Order> orders = Lists.newArrayList();
	private List<Warehouse> warehouses = Lists.newArrayList();

	@Override
	public HardSoftScore getScore() {
		return score;
	}
	@Override
	public void setScore(HardSoftScore score) {
		this.score = score;
	}
	
	@Override
	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = Lists.newArrayList();
		
		facts.addAll(drones);
		facts.addAll(orders);
		facts.addAll(warehouses);
		
		return facts;
	}
	
	@ValueRangeProvider(id = "orders")
	public Collection<Order> getOrders() {
		return orders;
	}
	
	@PlanningEntityCollectionProperty
	public Collection<Item> getItems() {
		List<Item> items = Lists.newArrayList();
		
		for (Warehouse warehouse : warehouses) {
			items.addAll(warehouse.itemsInWarehouse());
		}
		
		return items;
	}
}
