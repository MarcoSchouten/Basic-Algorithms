import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	FileReader f = new FileReader(args[0]);
	Scanner sc = new Scanner(f);
	
	// 0 - creo il grafo
	Graph myGraph = new Graph();
	int row = 1;
	while(sc.hasNext()) {
	    myGraph.buildCoordinates(sc.nextLine(), row);
	    row++;
	}
	myGraph.buildEdges();
	// System.out.println(myGraph.toString());
	

	// 1 - faccio BFS
	myGraph.getPaths();
	sc.close();
    }
}
