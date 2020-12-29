package lorenzo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	if (args.length < 1) {
	    return;
	}

	try {
	    FileReader fr = new FileReader(args[0]);
	    Scanner in = new Scanner(fr);

	    int n = Integer.parseInt(in.nextLine());
	    int[][] matrice = new int[n][n];
	    String[] line = new String[n];
	    int i = 0;
	    while (in.hasNext()) {
		line = in.nextLine().split(" ");
		for (int j = 0; j < n; j++) {
		    matrice[i][j] = Integer.parseInt(line[j]);
		}
		i++;
	    }
	    Graph grafo = new Graph(matrice);
	    in.close();
	    grafo.minimoAlb();
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	}

    }

}
