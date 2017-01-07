package me.phil.droneplanner.textadapter;

import java.io.Reader;
import me.phil.droneplanner.domain.DeliveryPlan;


public class PlanningProblemReader {
	/**
	 * Reads stream and constructs an unsolved plan (i.e. one where deliveries have not been scheduled)
	 * 
	 * The problem stream defines the problem
	 * Returns an unsolved plan describing the data.
	 */
	public static DeliveryPlan newPlanFromStream(Reader problemReader) {
		return DeliveryPlan.newInstance();
	}
}
