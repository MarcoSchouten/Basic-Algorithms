package artificialLife;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Artificial food area featuring a position, a size and a given number of food
 * units
 * 
 * @author tac
 *
 */
public class Food implements Drawable {

    public static final double MIN_AREA = 0.05;
    public static final double MAX_AREA = 0.1;
    public static final int INITIAL_FEED_CAPACITY = 100;

    private static int foodCount = 0;

    private double x;
    private double y;
    private double feedRadius;
    private int feedCapacity;

    /**
     * Constructor randomly creates a food area of a given radius on the canvas
     * 
     * @param feedRadius is the radius of the food area
     */
    public Food(double feedRadius) {
	assert ((feedRadius >= MIN_AREA) && (feedRadius <= MAX_AREA));
	setFeedCapacity((int) StdRandom.gaussian(30, 10));
	x = StdRandom.uniform();
	y = StdRandom.uniform();
	this.feedRadius = feedRadius;
	feedCapacity = INITIAL_FEED_CAPACITY;
	foodCount++;
    }

    /**
     * Get the radius of the food area
     * 
     * @return double value (radius)
     */
    public double getFeedRadius() {
	return feedRadius;
    }

    /**
     * Get how many food object are currently "active"
     * 
     * @return int value (food objects)
     */
    public static int getObjectCount() {
	return foodCount;
    }

    /**
     * Check whether the food area can feed a given creature
     * 
     * @param c the creature to be tested
     * @return true if the creature can be fed
     */

    public boolean canFeed(Creature c) {
	double number1 = c.getX() - this.x;
	double number2 = c.getY() - this.y;
	number1 = Math.pow(number1, 2);
	number2 = Math.pow(number2, 2);
	double distance = Math.sqrt(number1 + number2);
	if (distance < this.getFeedRadius())
	    return true;
	else {
	    return false;
	}
    }

    /**
     * Decrease the feeding capacity by a given amount of units
     * 
     * @param feeds units to be decreased
     */
    public void decreaseFeedCapacityBy(int feeds) {
	assert (feeds >= 0);
	this.setFeedCapacity(this.getFeedCapacity() - feeds);
    }

    /*
     * (non-Javadoc)
     * 
     * @see Drawable#draw()
     */
    public void draw() {
	StdDraw.setPenColor(StdDraw.GREEN);
	StdDraw.filledCircle(x, y, feedRadius);
	StdDraw.setPenColor(StdDraw.BLACK);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#finalize()
     */
    protected void finalize() {
	foodCount -= 1;
    }

    public double getX() {
	return x;
    }

    public void setX(double x) {
	this.x = x;
    }

    public double getY() {
	return y;
    }

    public void setY(double y) {
	this.y = y;
    }

    public int getFeedCapacity() {
	return feedCapacity;
    }

    public void setFeedCapacity(int feedCapacity) {
	this.feedCapacity = feedCapacity;
    }

}
