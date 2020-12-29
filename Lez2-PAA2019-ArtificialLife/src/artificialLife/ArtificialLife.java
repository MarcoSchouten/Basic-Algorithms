package artificialLife;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Artificial Life simulator
 * 
 * @author tac
 *
 */
public class ArtificialLife {
    /**
     * Simulation period (in milliseconds) Smaller periods imply faster simulations
     */
    public static final long STEP_DURATION = 100;

    private int birthRate; // Birth rate (cycles)
    private int foodRate; // Food regeneration reate (cycles)
    private int horizon; // Number of simulation cycles

    ArrayList<Creature> creatures; // Alive creatures
    ArrayList<Food> pastures; // Available food areas

    /**
     * Constructor set up a simulation with given birth and regerenation rates and a
     * fized horizon (number of cycles)
     * 
     * @param birthRate
     * @param foodRate
     * @param horizon
     */
    ArtificialLife(int birthRate, int foodRate, int horizon) {
	assert ((birthRate > 0) && (foodRate > 0) && (horizon > 0));
	this.birthRate = birthRate;
	this.foodRate = foodRate;
	this.horizon = horizon;
	creatures = new ArrayList<Creature>();
	pastures = new ArrayList<Food>();

    }

    /**
     * Run the simulation
     */
    public void doSimulation() {
	// Update the graphical representation only if needed
	boolean mustUpdate = false;

	for (int step = 0; step < horizon; ++step) {
	    // Every 'birthRate' cycles a new creature is generated
	    if (step % birthRate == 0) {
		Creature baby = new Creature();
		creatures.add(baby);
		mustUpdate = true;
	    }
	    // Every 'foodRate' cycles a new food area is generated
	    if (step % foodRate == 0) {
		Food pasture = new Food(StdRandom.uniform(Food.MIN_AREA, Food.MAX_AREA));
		pastures.add(pasture);
		mustUpdate = true;
	    }
	    // Two empty lists to store dead creatures and empty food areas
	    // in this simulation cycle
	    LinkedList<Creature> departedCreatures = new LinkedList<Creature>();
	    LinkedList<Food> schorchedLands = new LinkedList<Food>();
	    for (Creature c : creatures) {
		// For each creature c...
		boolean hasEaten = false;
		for (Food pasture : pastures) {
		    // For each food area f...
		    if (c.canEat(pasture)) {
			// If 'c' can eat in 'f' a food unit is subtracted from 'f'
			pasture.decreaseFeedCapacityBy(1);
			// The creature has eaten: its residual life is increased
			c.updateLife(true);
		    }
		    // If 'pasture' is empty it goes to 'schorchedLand' lists
		    if (pasture.getFeedCapacity() < 0) {
			schorchedLands.add(pasture);
			mustUpdate = true;
		    }
		}
		// If 'c' did not eat in this cycle, then its residual
		// life is decreased
		if (!hasEaten) {
		    c.updateLife(false);
		}
		// If the residual life of the creature is 0, then it is dead
		if (c.getResidualLife() < 0) {
		    departedCreatures.add(c);
		    mustUpdate = true;
		}
	    }

	    // If 'mustUpdate' is true there are new creatures, new pastures or
	    // creatures are dead, or food areas are finished up
	    if (mustUpdate) {
		// Remove creatures and food areas
		for (Creature c : departedCreatures) {
		    creatures.remove(c);
		}
		for (Food f : schorchedLands) {
		    pastures.remove(f);
		}
		// Regenerate the scenario graphically
		StdDraw.clear();
		for (Food f : pastures) {
		    f.draw();
		}
		for (Creature c : creatures) {
		    c.draw();
		}
		mustUpdate = false;
	    }
	    try {
		// Stop execution for STEP_DURATION milliseconds - permette di fare neinte e
		// vedere a schermo
		Thread.sleep(STEP_DURATION);
	    } catch (InterruptedException e) {
		// Do nothing
	    }
	}
    }

    public int getPastureCount() {
	return pastures.size();
    }

    public int getCreatureCount() {
	return creatures.size();
    }

}
