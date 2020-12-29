package artificialLife;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Artificial creature featuring a position and an initial amount of life
 * points. Life can be increased by eating
 * 
 * @author tac
 *
 */
public class Creature implements Drawable {

    public static final int INITIAL_LIFE = 10;
    private static final double SIZE = 0.05;

    private static int populationCount = 0;
    private static int totalIndividuals = 0;

    private double x;
    private double y;
    private int residualLife;

    /**
     * Constructor randomly creates an individual
     */
    public Creature() {
	residualLife = INITIAL_LIFE;
	x = StdRandom.uniform();
	y = StdRandom.uniform();
	populationCount++;
	totalIndividuals++;

    }

    public double getX() {
	return x;
    }

    public double getY() {
	return y;
    }

    public int getResidualLife() {
	return this.residualLife;
    }

    /**
     * Check if the creature can feed on the food area
     * 
     * @param f food area to be checked
     * @return true if the creature can feed on f
     */
    public boolean canEat(Food f) {
	double number1 = f.getX() - this.x;
	double number2 = f.getY() - this.y;
	number1 = Math.pow(number1, 2);
	number2 = Math.pow(number2, 2);
	double distance = Math.sqrt(number1 + number2);
	if (distance < f.getFeedRadius())
	    return true;
	else {
	    return false;
	}
    }

    /**
     * Update life points depending on whether the creature has eaten or not
     * 
     * @param hasEaten true if the creature has eaten
     */
    public void updateLife(boolean hasEaten) {
	if (hasEaten == true)
	    residualLife++;
	else
	    residualLife--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Drawable#draw()
     */
    public void draw() {
	StdDraw.filledCircle(x, y, SIZE);
    }

    /**
     * Get active individuals
     * 
     * @return integer value (number of active individuals)
     */
    public static int getObjectCount() {
	return populationCount;
    }

    /**
     * Get total individuals ever created
     * 
     * @return integer value (number of individuals created)
     */
    public static int getTotalIndividuals() {
	return totalIndividuals;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#finalize()
     */
    protected void finalize() {
	populationCount -= 1;
    }
}
