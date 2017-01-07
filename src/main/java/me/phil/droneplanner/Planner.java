package me.phil.droneplanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import me.phil.droneplanner.domain.DeliveryPlan;
import me.phil.droneplanner.textadapter.PlanningProblemReader;
import me.phil.droneplanner.textadapter.PlanningProblemWriter;

public class Planner {
    public static void main(String[] args) throws IOException {
        // Build the Solver
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(
                "me/phil/droneplanner/solverConfig.xml");
        Solver solver = solverFactory.buildSolver();

        DeliveryPlan unsolvedPlan = null;
		try (InputStream problemStream = Planner.class.getResourceAsStream("droneplanner-problem.txt")) {
			unsolvedPlan = PlanningProblemReader.newPlanFromStream(new InputStreamReader(problemStream));
		}        
       
		System.out.println("Problem loaded, solving...");
		
        // Solve the problem
        solver.solve(unsolvedPlan);
        DeliveryPlan solvedPlan = (DeliveryPlan) solver.getBestSolution();
        
        System.out.println("Final score = " + solvedPlan.getScore());

        PlanningProblemWriter.print(solvedPlan, System.out);
    }
}
