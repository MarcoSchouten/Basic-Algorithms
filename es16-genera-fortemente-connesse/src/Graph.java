import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    HashMap<Integer, ArrayList<Integer>> graph;
    HashMap<Integer, ArrayList<Integer>> stronglyConnected = new HashMap<>(); // contiene (id -> lista di elementi a cui

    public Graph() {
	this.graph = new HashMap<Integer, ArrayList<Integer>>();
    }

    public void addVertex(int vertex) {
	this.graph.put(vertex, new ArrayList<Integer>());
    }

    public void addEdge(int vertexA, int vertexB, boolean bidirectional) {
	if (this.graph.containsKey(vertexA)) {
	    this.graph.get(vertexA).add(vertexB);
	    if (bidirectional)
		this.graph.get(vertexB).add(vertexA);
	}
    }

    public boolean[] BFS(int start) {
	// inizializzo
	boolean[] visited = new boolean[graph.size()]; 
	Arrays.fill(visited, false);

	
	LinkedList<Integer> queue = new LinkedList<Integer>();
	queue.add(start);

	// calcolo
	while (!queue.isEmpty()) {
	    int node = queue.poll();
	    Iterator<Integer> iterator = graph.get(node).listIterator();
	    while (iterator.hasNext()) {
		int toVisit = iterator.next();
		if (visited[toVisit] == false) {
		    queue.push(toVisit);
		    visited[toVisit] = true;
		    
		}
	    }
	}
	return visited;
    }

    public void connessioniForti() {
	ArrayList<Integer> salta = new ArrayList<Integer>();

	for (int i = 0; i < graph.size() - 1; i++) {
	    if (salta.contains(i))
		continue;
	    this.stronglyConnected.put(i, new ArrayList<Integer>());
	   
	    for (int j = 1; j < graph.size(); j++) {
		if (connessi(i, j) && i != j) {
		    
		    this.stronglyConnected.get(i).add(j);
		    salta.add(j);
		}
	    }
	    System.out.println();
	}
    }

    private boolean connessi(int i, int j) {
	boolean[] conn1 = BFS(i);
	boolean[] conn2 = BFS(j);
	if (conn1[j] == conn2[i])
	    return true;
	return false;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (Integer node : this.graph.keySet()) {
	    sb.append(node + ": ");
	    Iterator<Integer> it = this.graph.get(node).iterator();
	    while (it.hasNext()) {
		Integer child = it.next();
		sb.append(child + " ");
	    }
	    sb.append("\n");

	}
	return sb.toString();
    }

    public String stronglyConnected() {
	StringBuilder sb = new StringBuilder();
	for (Integer node : this.stronglyConnected.keySet()) {
	    sb.append(node + " ");
	    Iterator<Integer> it = this.stronglyConnected.get(node).iterator();
	    while (it.hasNext()) {
		Integer child = it.next();
		sb.append(child + " ");
	    }
	    sb.append("\n");

	}
	return sb.toString();
    }

}