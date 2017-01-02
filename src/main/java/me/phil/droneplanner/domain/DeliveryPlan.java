package me.phil.droneplanner.domain;

import java.util.List;

import com.google.common.collect.Lists;

public class DeliveryPlan {
	public static DeliveryPlan newInstance() {
		return new DeliveryPlan();
	}

	private DeliveryMap deliveryMap = DeliveryMap.newInstance();
	private List<Drone> drones = Lists.newArrayList();
	private List<Order> orders = Lists.newArrayList();
	private List<Warehouse> warehouses = Lists.newArrayList();
}
