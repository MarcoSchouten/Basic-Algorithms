import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	FileReader f = new FileReader(args[0]);
	Scanner sc = new Scanner(f);

	Graph g = new Graph();

	int dim = Integer.parseInt(sc.nextLine());
	int[] total_order = new int[dim];

	String[] line = sc.nextLine().split(" ");
	for (int i = 0; i < dim; i++)
	    total_order[i] = Integer.parseInt(line[i]);
	
	//for (int i = 0; i < dim; i++)
	  //  System.out.print(total_order[i] + " ");
	
	while(sc.hasNext()) {
	    String[] nextLine = sc.nextLine().split(" ");
	    g.addVertex(Integer.parseInt(nextLine[0]));
	    g.addEdge(Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), false);
	}
	
	
	System.out.print(g.check(total_order));
	
	

	sc.close();
    }

}
