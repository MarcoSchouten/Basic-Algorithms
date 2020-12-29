
// Java program to implement Graph 
// with the help of Generics 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph {

    private Map<Node, List<Node>> map = new LinkedHashMap<>();
    private Node start;
    private ArrayList<Node> goal = new ArrayList<Node>();
    private Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    
    
    public int[] shortestPath(Node start) {
	for (Node v : map.keySet()) {
	    graph.put(v.id, new LinkedList<Integer>());
	    for (Node w : map.get(v)) {
		graph.get(v.id).add(w.id);
	    }
	}
	LinkedList<Integer> queue = new LinkedList<Integer>();
	queue.add(start.id);
	
	boolean[] visited = new boolean[graph.size()];
	int[] distances = new int[graph.size()]; // non serve perchése non ci arrivo rimane -1
	Arrays.fill(distances, -1);
	
	while(!queue.isEmpty()) {
	    int node = queue.poll();
	    for (int neighbor : graph.get(node)) {
		if (distances[neighbor] == -1) {
		    distances[neighbor] = distances[node]
		    queue.add(neighbor);
		}
	    }
	    //
	}
	return distances;
    }

    public void addVertex(Node n) { // This function adds a new vertex to the graph
	map.put(n, new LinkedList<Node>());
    }

    public void addEdge(Node source, Node destination) { // This function adds the edge between source to destination
	/*
	 * if (!map.containsKey(source)) addVertex(source); if
	 * (!map.containsKey(destination)) addVertex(destination);
	 */
	map.get(source).add(destination);
	// map.get(destination).add(source);
    }

    @Override
    public String toString() { // Prints the adjancency list of each vertex.
	StringBuilder builder = new StringBuilder();
	for (Node v : map.keySet()) {
	    builder.append(v.toString() + ": ");
	    for (Node w : map.get(v)) {
		builder.append(w.toString() + " ");
	    }
	    builder.append("\n");
	}
	return (builder.toString());
    }

    public void buildNodes(String nextLine, int row) {
	char[] lineC = nextLine.toCharArray();
	for (int col = 0; col < lineC.length; col++) {
	    if (lineC[col] == ' ') {
		addVertex(new Node(row, col + 1));
	    } else if (lineC[col] == '0') {
		start = new Node(row, col + 1);
		addVertex(start);
	    } else if (Character.isDigit(lineC[col])) {
		Node n = new Node(row, col + 1);
		goal.add(n);
		addVertex(n);
	    }
	}
    }

    public void buildEdges() {

	for (Node n : map.keySet()) {
	    Node north = new Node(n.row - 1, n.col);
	    Node south = new Node(n.row + 1, n.col);
	    Node east = new Node(n.row, n.col + 1);
	    Node west = new Node(n.row, n.col - 1);

	    if (map.containsKey(contains(north))) 
		addEdge(n, contains(north));
	    if (map.containsKey(contains(south)))
		addEdge(n, contains(south));
	    if (map.containsKey(contains(east)))
		addEdge(n, contains(east));
	    if (map.containsKey(contains(west)))
		addEdge(n, contains(west));

	}
    }

    private Node contains(Node tocompare) {
	for (Node n : map.keySet()) {
	    if (n.equals(tocompare))
		return n;
	}
	return null;
    }
}
