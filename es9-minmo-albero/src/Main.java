import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
	// variables
	FileReader f = new FileReader(args[0]);
	Scanner sc = new Scanner(f);
	int size = Integer.parseInt(sc.nextLine());
	int[][] graph = new int[size][size];
	int sum_of_all_weights = 0;

	// 0 - reads from input
	for (int i = 0; i < size; i++) {
	    String[] s = sc.nextLine().split(" ");
	    for (int j = 0; j < size; j++) {
		graph[i][j] = Integer.parseInt(s[j]);
		sum_of_all_weights += graph[i][j];
	    }
	}
	primMST(graph, size, sum_of_all_weights );
	sc.close();
    }

    // Returns true if edge u-v is a valid edge to be
    // include in MST. An edge is valid if one end is
    // already included in MST and other is not in MST.
    static boolean isValidEdge(int u, int v, boolean[] inMST) {
	if (u == v)
	    return false;
	if (inMST[u] == false && inMST[v] == false)
	    return false;
	else if (inMST[u] == true && inMST[v] == true)
	    return false;
	return true;
    }

    static void primMST(int cost[][] , int V, int max) {
	boolean[] inMST = new boolean[V];

	// Include first vertex in MST
	inMST[0] = true;

	// Keep adding edges while number of included
	// edges does not become V-1.
	int edge_count = 0, mincost = 0;
	while (edge_count < V - 1) {
	    // Find minimum weight valid edge.
	    int min = max, a = -1, b = -1;
	    for (int i = 0; i < V; i++) {
		for (int j = 0; j < V; j++) {
		    if (cost[i][j] < min) {
			if (isValidEdge(i, j, inMST)) {
			    min = cost[i][j];
			    a = i;
			    b = j;
			}
		    }
		}
	    }

	    if (a != -1 && b != -1) {
		System.out.printf("Edge-id-%d: (%d, %d) cost: %d \n", edge_count++, a, b, min);
		mincost = mincost + min;
		inMST[b] = inMST[a] = true;
	    }
	}
	System.out.printf("\n Minimum cost = %d \n", mincost);
    }
}
