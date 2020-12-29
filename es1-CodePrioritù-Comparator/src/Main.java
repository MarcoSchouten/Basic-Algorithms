

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

	// 0 - lettura da input
	PriorityQueue<Process> pq = new PriorityQueue<Process>(new ProcessComparator()); // The head of this queue is
											 // the least element with
											 // respect to the specified
											 // ordering
	
	
	FileReader f = new FileReader("input.txt");
	Scanner sc = new Scanner(f);

	while (sc.hasNext()) {
	    String[] input = sc.nextLine().split(" ");
	    String id = input[0];
	    String priority = input[1];
	    String residual_time = input[2];
	    Process p = new Process(Integer.parseInt(id), Integer.parseInt(priority), Integer.parseInt(residual_time));
	    pq.add(p);
	}
	sc.close();

	// poll method is used to access the head element of queue
	System.out.println("Priority served in their priority order");

	// 2 - calcolo step by step
	while (!pq.isEmpty()) {
	    Process p = pq.poll();
	    int initial_priority = p.priority;
	    p.priority = p.priority - 1;
	    if (p.residual_time > 10) {
		p.residual_time = p.residual_time - 10;
	    } else {
		p.residual_time = 0;
	    }
	    System.out.println(p.id + " " + initial_priority + " " + p.priority + " " + p.residual_time);
	    if (p.residual_time > 0) {
		pq.add(p);
	    }
	}
    }

}
