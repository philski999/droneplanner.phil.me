package me.phil.activityplanner.textadapter;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import me.phil.droneplanner.domain.DeliveryPlan;
import me.phil.droneplanner.textadapter.PlanningProblemReader;

import org.junit.Test;

public class PlanningProblemReaderTest {

	@Test
	public void testNewPlanFromCSVFile() throws IOException {
		try (InputStream problemStream = getClass().getResourceAsStream("droneplanner-problem.txt")) {
			DeliveryPlan plan = PlanningProblemReader.newPlanFromStream(new InputStreamReader(problemStream));
			
			assertThat("Plan exists", plan, is(notNullValue()));
		}
	}

}
