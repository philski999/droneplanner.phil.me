package me.phil.droneplanner.csvadapter;

import java.io.Reader;
import java.util.List;

import com.google.common.collect.Lists;

import me.phil.droneplanner.domain.Activity;
import me.phil.droneplanner.domain.Assignment;
import me.phil.droneplanner.domain.Day;
import me.phil.droneplanner.domain.Plan;


public class PlanningProblemReader {
	/**
	 * Reads csv stream and constructs an unsolved plan (i.e. one where deliveries have not been scheduled)
	 * 
	 * The problem stream defines the problem
	 * 
	 * Returns an unsolved plan describing the data.
	 */
	public static Plan newPlanFromCSV(Reader problemReader) {
		List<Activity> activities = Lists.newArrayList();
		List<Assignment> assignments = Lists.newArrayList();
		List<Day> assignmentDays = Lists.newArrayList();

		return new Plan(activities, assignments, assignmentDays);
	}
}
