package me.phil.droneplanner.domain;

import java.util.Map;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ScoreCalculator implements EasyScoreCalculator<DeliveryPlan> {

	public HardSoftScore calculateScore(DeliveryPlan solution) {
		int hardScore = 0 ;
		int softScore = 0 ;
		
		// Find out how many items of each type have been mapped to each order
		Multimap<Order, Item> orderItems = ArrayListMultimap.create();
		for (Item item : solution.getItems()) {
			if (item.getAssignedOrder() != null) {
				orderItems.put(item.getAssignedOrder(), item);
			}
		}
		
		// Find out how many items of each type have not been fulfilled.
		// i.e. count(items of productType assigned to order) - count(items of productType requiredBy order)
		for (Order order : solution.getOrders()) {
			Map<ProductType, Integer> orderProducts = order.getLineItems();
			
			// TODO
		}

		return HardSoftScore.valueOf(hardScore, softScore);
	}

}
