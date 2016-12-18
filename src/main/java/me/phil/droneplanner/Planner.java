package me.phil.droneplanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import me.phil.droneplanner.csvadapter.PlanningProblemReader;
import me.phil.droneplanner.csvadapter.PlanningProblemWriter;
import me.phil.droneplanner.domain.Plan;

public class Planner {
    public static void main(String[] args) throws IOException {
        // Build the Solver
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(
                "me/phil/droneplanner/solverConfig.xml");
        Solver solver = solverFactory.buildSolver();

        Plan unsolvedPlan = null;
		try (InputStream problemStream = Planner.class.getResourceAsStream("activityplanner-problem.csv")) {
			unsolvedPlan = PlanningProblemReader.newPlanFromCSV(new InputStreamReader(problemStream));
		}        
       
		System.out.println("Problem loaded, solving...");
		
        // Solve the problem
        solver.solve(unsolvedPlan);
        Plan solvedPlan = (Plan) solver.getBestSolution();
        
        System.out.println("Final score = " + solvedPlan.getScore());

        PlanningProblemWriter.print(solvedPlan, System.out);
    }
}
