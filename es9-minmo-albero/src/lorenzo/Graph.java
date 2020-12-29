package lorenzo;

public class Graph {
    private int[][] adj;
    private int minT;

    public Graph(int[][] m) {
	adj = m;
	minT = 0;
	for (int i = 0; i < m.length; i++) {
	    for (int j = 0; j < m.length; j++) {
		minT += adj[i][j];
	    }
	}
    }

    public void minimoAlb() {
	int tot = 0;
	int destinazione = 0;
	int min = minT;
	System.out.println("MINT VALE" + minT);

	for (int i = 0; i < adj.length - 1; i++) {
	    min = minT;
	    for (int j = 0; j < adj.length; j++) {
		if (i != j && min > adj[i][j] && adj[i][j] != -1) {
		    min = adj[i][j];
		    adj[j][i] = -1;
		    destinazione = j;
		}
	    }
	    System.out.println((i + 1) + " " + (destinazione + 1) + " " + adj[i][destinazione]);
	    tot += adj[i][destinazione];
	}
	System.out.println(tot);
    }
}
