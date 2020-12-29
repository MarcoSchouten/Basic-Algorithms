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

	    Graph grafo = new Graph();
	    int i = 0;
	    while (in.hasNext()) {
		grafo.worldToGraph(in.nextLine(), i);
		i++;
	    }
	    in.close();
	    grafo.percorsiLab();
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	}
    }
}
