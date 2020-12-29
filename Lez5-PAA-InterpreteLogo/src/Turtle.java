import edu.princeton.cs.algs4.StdDraw;

public class Turtle implements Drawable {

    private double x;
    private double y;
    private boolean active;

    /**
     * constructor default
     */

    Turtle() {
	this.x = 0.5;
	this.y = 0.5;
	this.active = true;
    }

    /**
     * move prende un double e si sposta
     */
    public void draw_line_to(double end_x, double end_y) {
	StdDraw.line(this.x, this.y, end_x, end_y);
	this.x = end_x;
	this.y = end_y;
    }

    public void set_position(double end_x, double end_y) {
	this.x = end_x;
	this.y = end_y;
    }

    public boolean isActive() {
	return this.active;
    }

    public void setActive() {
	this.active = true;
    }

    public void setInactive() {
	this.active = false;
    }

    public double getX() {
	return this.x;
    }

    public double getY() {
	return this.y;
    }
}
