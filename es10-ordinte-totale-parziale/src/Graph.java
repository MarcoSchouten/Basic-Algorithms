import java.util.ArrayList;
import java.util.HashMap;

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

    public String check(int[] total_order) {
	for (Integer node : graph.keySet()) {
	    int father = findIndex (total_order, node);
	    for (Integer link : graph.get(node)) {
		int child = findIndex (total_order, link);
		if (father > child)
		    return "NO";
	    }
	}
	return "SI";
    }

    private static int findIndex(int[] a, int target) {
	for (int i = 0; i < a.length; i++)
	    if (a[i] == target)
		return i;
	return -1;
    }

}
