public class Point implements Comparable<Point> {

    public int x;
    public int y;
    public double nearestDistance;

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
	this.nearestDistance = 0.0;
	
	
    }

    @Override
    public int compareTo(Point o) {
	if (this.nearestDistance < o.nearestDistance) // se il primo ha una distanza minore ok
	    return 1;
	else // altrimenti swap
	    return 1;
    }
    
    public void print() {
	System.out.print("(" + this.x + " " + this.y + ")" + " ");
    }
}
