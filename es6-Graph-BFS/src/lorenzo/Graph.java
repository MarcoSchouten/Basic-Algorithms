package lorenzo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    // private HashMap<Integer, ArrayList<Boolean>> adj = new HashMap<Integer,
    // ArrayList<Boolean>>();
    private ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    private HashMap<Integer, Coordinate> nodi = new HashMap<Integer, Coordinate>();
    private int numNodi;
    private int obiettivo1;
    private int obiettivo2;
    private int partenza;

    public Graph() {
	numNodi = 0;
    }

    public void worldToGraph(String line, int riga) {
	char[] lineC = line.toCharArray();

	for (int i = 0; i < lineC.length; i++) {
	    if (lineC[i] == ' ') {
		nodi.put(numNodi, new Coordinate(riga, i));
		// System.out.println("Nodo: " + numNodi + " (" + riga + ", " + i + ")");
		numNodi++;
	    } else if (lineC[i] == '0') {
		partenza = riga;
		nodi.put(numNodi, new Coordinate(riga, i));
		// System.out.println("Nodo Partenza: " + numNodi + " (" + riga + ", " + i +
		// ")");
		numNodi++;
	    } else if (lineC[i] == '1') {
		obiettivo1 = numNodi;
		nodi.put(numNodi, new Coordinate(riga, i));
		// System.out.println("Nodo 1: " + numNodi + " (" + riga + ", " + i + ")");
		numNodi++;
	    } else if (lineC[i] == '2') {
		obiettivo2 = numNodi;
		nodi.put(numNodi, new Coordinate(riga, i));
		// System.out.println("Nodo 2: " + numNodi + " (" + riga + ", " + i + ")");
		numNodi++;
	    }
	}
    }

    private void creaEdge() {
	for (int i = 0; i < numNodi; i++) {
	    adj.add(new ArrayList<Integer>());
	}

	for (int i = 0; i < numNodi - 1; i++) {
	    for (int j = 0; j < numNodi; j++) {
		if (nodi.get(i).getRiga() == nodi.get(j).getRiga()) {
		    if (nodi.get(i).getCol() == nodi.get(j).getCol() + 1
			    || nodi.get(i).getCol() == nodi.get(j).getCol() - 1) {
			adj.get(i).add(j);
		    }
		}
		if (nodi.get(i).getCol() == nodi.get(j).getCol()) {
		    if (nodi.get(i).getRiga() == nodi.get(j).getRiga() + 1
			    || nodi.get(i).getRiga() == nodi.get(j).getRiga() - 1) {
			adj.get(i).add(j);
		    }
		}
	    }
	}
    }

    public ArrayList<Integer> BFS(int s) {
	boolean visited[] = new boolean[numNodi];
	ArrayList<Integer> distanzaNodo = new ArrayList<Integer>();
	for (int i = 0; i < numNodi; ++i) {
	    visited[i] = false;
	    distanzaNodo.add(0);
	}
	// int distanzaNodo[] = new int[numNodi];
	LinkedList<Integer> queue = new LinkedList<Integer>();

	visited[s] = true;
	queue.add(s);
	// System.out.println("a");
	while (queue.size() != 0) {
	    s = queue.poll();
	    // System.out.println("b");
	    Iterator<Integer> i = adj.get(s).listIterator();
	    while (i.hasNext()) {
		int n = i.next();
		// System.out.println("c");
		if (!visited[n]) {
		    visited[n] = true;
		    queue.add(n);
		    // distanzaNodo.set(n, d);
		    distanzaNodo.set(n, distanzaNodo.get(s) + 1);
		    // System.out.print("-" + distanzaNodo.get(s));
		}
	    }
	    // System.out.println();
	}
	return distanzaNodo;
    }

    public void percorsiLab() {
	creaEdge();
	ArrayList<Integer> dist = BFS(partenza);
	System.out.println("1 " + (dist.get(obiettivo1) - 1));
	System.out.println("2 " + (dist.get(obiettivo2) - 1));
    }
}
