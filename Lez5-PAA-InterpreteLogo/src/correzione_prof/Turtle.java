package correzione_prof;

import edu.princeton.cs.algs4.StdDraw;

public class Turtle {

    private double x; // Position and heading are private as they define the
    private double y; // status of the turtle and are manipulated by methods only
    private double heading; // penDown is public because it is a simple flag
    public boolean penDown;

    /**
     * Default constructor. The turtle is initialized at the center 
     * of the canvas oriented towards the top 
     */
    public Turtle() {
	x = 0.5;
	y = 0.5;
	heading = Math.PI / 2;
	penDown = true;
	StdDraw.point(x, y);
    }

    /**
     * Moving the turtle
     * 
     * @param steps how many steps
     */
    public void move(double steps) {
	// Compute the destination position based on the current one
	// 'steps' is the module and 'heading' is the phase 
	// Draw a line if 'penDown' is 'true'. The position is updated.
	double toX = x + steps * Math.cos(heading);
	double toY = y + steps * Math.sin(heading);
	if (penDown) {
	    StdDraw.line(x, y, toX, toY);
	}
	x = toX;
	y = toY;
    }

    /**
     * Rotating the turtle
     * 
     * @param degrees rotation angle (counterclockwise)
     */
    public void rotate(double degrees) {
	double radians = Math.toRadians(degrees);
	heading += radians;
    }

}
