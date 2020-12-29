import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	FileReader f = new FileReader(args[0]);
	Scanner sc = new Scanner(f);
	Graph g = new Graph();
	
	int dim = Integer.parseInt(sc.nextLine());
	for (int i = 0; i < dim; i++) {
	    g.addVertex(i);
	}
	while(sc.hasNext()) {
	    String[]  line = sc.nextLine().split(" ");
	    g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), true);
	}
	
	System.out.print("stampo il grafo. \n"  + g.toString());
	// faccio bfs per ogni nodo, se li visita tutti gli altri allora è un buon nodo.
	 System.out.print(g.checkStronglyConnected());
	
	
	sc.close();

    }

}
