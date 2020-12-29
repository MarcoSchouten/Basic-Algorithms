import java.util.Comparator;

public class printComparator implements Comparator<Point> {
	    @Override
	    public int compare(Point o1, Point o2) {
		if (o1.x < o1.x) 
		    return 1;
		else if (o1.x > o1.x) 
		    return -1;
		else  {
		    if (o1.y < o1.y) 
			    return 1;
			else 
			    return -1;
		}
	
	    }
}
