import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

    private Map<Integer, ArrayList<Integer>> adj = new LinkedHashMap<Integer, ArrayList<Integer>>(); // è il
												     // grafo
    private Map<Integer, Coordinate> nodes = new LinkedHashMap<Integer, Coordinate>(); // mappa id -->
										       // coordinata
    public int start;
    // public ArrayList<Integer> goal = new ArrayList<Integer>();
    private Map<Integer, Integer> goal = new LinkedHashMap<Integer, Integer>(); // mappa id --> valore

    public void buildCoordinates(String nextLine, int row) {
	char[] lineC = nextLine.toCharArray();

	for (int col = 0; col < lineC.length; col++) {
	    if (lineC[col] == ' ') {
		nodes.put(nodes.size(), new Coordinate(row, col));

	    } else if (lineC[col] == '0') {
		start = nodes.size();
		nodes.put(nodes.size(), new Coordinate(row, col));

	    } else if (Character.isDigit(lineC[col])) {
		goal.put(nodes.size(), Integer.parseInt("" + lineC[col] + ""));
		nodes.put(nodes.size(), new Coordinate(row, col));
	    }
	}
    }

    public void buildEdges() {
	for (int i = 0; i < nodes.size(); i++) {
	    adj.put(i, new ArrayList<Integer>()); // inizializza il grafo a null;
	}
	// Aggiunge collegamenti se pertinente
	for (int i = 0; i < nodes.size() - 1; i++) {
	    for (int j = 0; j < nodes.size(); j++) {
		if (nodes.get(i).row == nodes.get(j).row) {
		    if (nodes.get(i).col == nodes.get(j).col + 1 || nodes.get(i).col == nodes.get(j).col - 1) {
			adj.get(i).add(j);
		    }
		}
		if (nodes.get(i).col == nodes.get(j).col) {
		    if (nodes.get(i).row == nodes.get(j).row + 1 || nodes.get(i).row == nodes.get(j).row + -1) {
			adj.get(i).add(j);
		    }
		}
	    }
	}
    }

    @Override
    public String toString() { // Prints the adjancency list of each vertex.
	StringBuilder builder = new StringBuilder();
	for (Integer v : adj.keySet()) {
	    builder.append(v.toString() + ": ");
	    for (Integer w : adj.get(v)) {
		builder.append(w.toString() + " ");
	    }
	    builder.append("\n");
	}
	return (builder.toString());
    }

    public int[] BFS(int start) {
	// inizializzo
	int[] distances = new int[adj.size()]; // distances[-1,-1,24,0,0,0,0,0,,0,0,0...
	int[] pred = new int[adj.size()];
	Arrays.fill(distances, -1);
	Arrays.fill(pred, -1);
	
	LinkedList<Integer> queue = new LinkedList<Integer>();
	queue.add(start);

	// calcolo
	while (!queue.isEmpty()) {
	    int node = queue.poll();
	    Iterator<Integer> iterator = adj.get(node).listIterator();
	    while (iterator.hasNext()) {
		int toVisit = iterator.next();
		if (distances[toVisit] < 0) {
		    queue.add(toVisit);
		    distances[toVisit] = distances[node] + 1;
		    pred[toVisit] = node;
		    //System.out.print(pred[toVisit]);
		}
	    }
	}
	pred[start] = -1;
	return pred;
    }

    public void getPaths() {
	 //int[] dist = BFS(start);
	 //for (Integer id : goal.keySet())
	 //System.out.println(goal.get(id) + ": " + (dist[id]));
	int[] pred = BFS(start);
	
	
	
	for (Integer id : goal.keySet()) {
	    ArrayList<Integer> path = new ArrayList<Integer>();
	    
	    int crawl = id; 
	    
	    while (pred[crawl] != -1) { 
	        path.add(crawl); //aggiunge il figlio 
	        crawl = pred[crawl];  // salgo di generazioen assegnando il figlio il valore del padre
	        
	    } 
	    for (int i = path.size() - 1; i >= 0; i--) {
		System.out.print("["+ path.get(i) + "]");
		
	    }
	    System.out.println("\n");
	}
    }
}