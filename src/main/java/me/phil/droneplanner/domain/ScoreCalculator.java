package me.phil.droneplanner.domain;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class ScoreCalculator implements EasyScoreCalculator<DeliveryPlan> {

	public HardSoftScore calculateScore(DeliveryPlan solution) {
		int hardScore = 0 ;
		int softScore = 0 ;
		
		for (Order order : solution.getOrders()) {
			softScore += order.getScore();
		}

		return HardSoftScore.valueOf(hardScore, softScore);
	}

}
