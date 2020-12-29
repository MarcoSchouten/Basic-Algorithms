

import java.util.Comparator;

class ProcessComparator implements Comparator<Process> {

    // Overriding compare()method of Comparator
    // se vi sono piu processi con la stessa priorita massima, viene privilegiato quello
    // con identificativo minore;
    
    public int compare(Process p1, Process p2) {
	// ordino da priority più piccolo al più grande
	if (p1.priority < p2.priority)
	    return 1;
	// ordino da priority più piccolo al più grande
	else if (p1.priority > p2.priority)
	    return -1;
	
	else {
	 // ha priorità id minore 
	    
	  // quindi sarebbe id1 < id2 return 1
	    if (p1.id > p2.id)
		return 1;
	    else 
		return -1;
	}
    }
}