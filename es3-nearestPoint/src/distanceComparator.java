import java.util.Comparator;

public class distanceComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
	if (o1.nearestDistance > o2.nearestDistance)
	    return 1;
	else
	    return -1;
    }
}
