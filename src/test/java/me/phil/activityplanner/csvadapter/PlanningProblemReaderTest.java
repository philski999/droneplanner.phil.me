package me.phil.activityplanner.csvadapter;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import me.phil.droneplanner.csvadapter.PlanningProblemReader;
import me.phil.droneplanner.domain.Plan;

import org.junit.Test;

public class PlanningProblemReaderTest {

	@Test
	public void testNewPlanFromCSVFile() throws IOException {
		try (InputStream problemStream = getClass().getResourceAsStream("droneplanner-problem.csv")) {
			Plan plan = PlanningProblemReader.newPlanFromCSV(new InputStreamReader(problemStream));
			
			assertThat("Plan contains availability", plan.getAssignmentDays().size(), is(greaterThan(0)));
			assertThat("Plan contains targets", plan.getActivities().size(), is(greaterThan(0)));
		}
	}

}
