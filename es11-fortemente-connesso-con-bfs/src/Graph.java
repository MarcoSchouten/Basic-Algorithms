import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    HashMap<Integer, ArrayList<Integer>> graph;

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

    public String checkStronglyConnected() {
	for (Integer node : graph.keySet()) {
	    boolean[] visitedNodes = BFS(node);
	    if (!checkIfAllTrue(visitedNodes))
		return "NO";
	}
	return "SI";
    }

    private boolean[] BFS(int start) {

	boolean[] visited = new boolean[graph.size()];
	Arrays.fill(visited, false);
	LinkedList<Integer> queue = new LinkedList<Integer>();
	queue.push(start);

	while (!queue.isEmpty()) {
	    int node = queue.poll();
	    Iterator<Integer> it = graph.get(node).iterator();
	    while (it.hasNext()) {
		int toVisit = it.next();
		if (visited[toVisit] == false) {
		    queue.push(toVisit);
		    visited[toVisit] = true;
		}
	    }
	}
	System.out.print("Starting as [" + start + "], you can visit \n");
	for (int i = 0; i < visited.length; i++) 
	    System.out.print("node ["+ i  + "] ? " + visited[i] + "\n");

	return visited;
    }

    private boolean checkIfAllTrue(boolean[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == false)
		return false;
	}
	return true;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (Integer node : graph.keySet()) {
	    sb.append(node + ": ");
	    Iterator<Integer> it = graph.get(node).iterator();
	    while (it.hasNext()) {
		Integer child = it.next();
		sb.append(child + " ");
	    }
	    sb.append("\n");

	}
	return sb.toString();
    }
}
