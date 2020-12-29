import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// 0 - read from file
	FileReader f = new FileReader("input.txt");
	Scanner sc = new Scanner(f);
	ArrayList<Point> coordinates = new ArrayList<Point>();
	ArrayList<Point> deletedPoints = new ArrayList<Point>();

	while (sc.hasNext()) {
	    String[] input = sc.nextLine().split(" ");
	    Point p = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
	    coordinates.add(p);
	}

	// 1 - process
	System.out.println("Quanti punti vuoi eliminare?");
	Scanner in = new Scanner(System.in);
	int cycles = Integer.parseInt(in.nextLine());
	int number_of_cycles = 0;
	while (number_of_cycles < cycles) {
	    // assign a basic distance
	    for (int i = 1; i < coordinates.size(); i++) {
		double distance = computeDistance(coordinates.get(i), coordinates.get(0));
		coordinates.get(i).nearestDistance = distance;
	    }
	    double d = computeDistance(coordinates.get(1), coordinates.get(0));
	    coordinates.get(0).nearestDistance = d;

	    // compute nearest distance
	    for (int i = 0; i < coordinates.size(); i++) {
		for (int j = 0; j < coordinates.size(); j++) {
		    if (i != j) {
			double distance = computeDistance(coordinates.get(i), coordinates.get(j));
			if (coordinates.get(i).nearestDistance > distance)
			    coordinates.get(i).nearestDistance = distance;
		    }
		}
	    }
	    System.out.println("DISTANCE SORTING:");
	    Collections.sort(coordinates, new distanceComparator());
	    print(coordinates);
	    System.out.println();

	    // search for point to delete
	    double minDistance = coordinates.get(0).nearestDistance;
	    Point toDelete = coordinates.get(0);
	    int i = 1;
	    do {
		if (toDelete.y < coordinates.get(i).y)
		    toDelete = coordinates.get(i);
		else if (toDelete.y == coordinates.get(i).y)
		    if (toDelete.x < coordinates.get(i).x)
			toDelete = coordinates.get(i);
		i++;
	    } while ((i < coordinates.size()) && (coordinates.get(i).nearestDistance == minDistance));

	    // elimina il punto trovato
	    deletedPoints.add(toDelete);
	    coordinates.remove(toDelete);
	    number_of_cycles++;
	}

	System.out.println("REMOVED:");
	Collections.sort(deletedPoints, new printComparator());
	print(deletedPoints);
	System.out.println();
	in.close();
	sc.close();
    }

    private static double computeDistance(Point point, Point point2) {
	double a = Math.pow(point2.x - point.x, 2);
	double b = Math.pow(point2.y - point.y, 2);
	return Math.sqrt(a + b);
    }

    private static void print(ArrayList<Point> coordinates) {
	for (Point p : coordinates) {
	    p.print();
	    System.out.print(p.nearestDistance + "\n");
	}
    }
}
