import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

	// 0 - read input ------------------------------------------------------------
	FileReader f = new FileReader(args[0]);
	Scanner sc = new Scanner(f);
	String[] header = sc.nextLine().split(" ");
	int min_working_hours = Integer.parseInt(header[2]);

	ArrayList<Lezione> lessons = new ArrayList<Lezione>();

	while (sc.hasNext()) {
	    String[] input = sc.nextLine().split(" ");
	    Lezione l = new Lezione(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),
		    Integer.parseInt(input[3]));
	    lessons.add(l);
	}

	// 1 - process

	// check VINCOLO 1
	// -###################################################################### //
	// Nessun ossia due lezioni con lo stesso docente e aula diversa,
	// necessariamente devono avere data diversa
	HashSet<Lezione> violation1 = new HashSet<Lezione>();
	Collections.sort(lessons, new sortDocente());
	for (Lezione l : lessons) {
	    l.print();
	}
	for (int i = 0; i < lessons.size(); i++) {
	    for (int j = i + 1; j < lessons.size(); j++) {
		if (lessons.get(i).docente == lessons.get(j).docente) { // se lo stesso docente

		    if (lessons.get(i).aula != lessons.get(j).aula) { // fa lezione in aule diversa

			if (lessons.get(i).giorno == lessons.get(j).giorno) // nello stesso giorno stesso giorno
			    if (lessons.get(i).ora == lessons.get(j).ora) { // e nella stessa ora stessa ora

				violation1.add(lessons.get(i));
			    }
		    }
		}
	    }
	}
	System.out.println("Violazioni vincolo 1 : " + violation1.size());

	// check VINCOLO 2
	// -###################################################################### //
	// Nessuna aula e' allocata contemporaneamente a due docenti diversi
	HashSet<Lezione> violation2 = new HashSet<Lezione>();
	Collections.sort(lessons, new sortAula());
	for (int i = 0; i < lessons.size(); i++) {
	    for (int j = i + 1; j < lessons.size(); j++) {
		if (i != j) { // per lezioni diverse
		    if (lessons.get(i).aula == lessons.get(j).aula) { // stessa aula
			if (lessons.get(i).giorno == lessons.get(j).giorno) { // stesso giorno
			    if (lessons.get(i).ora == lessons.get(j).ora) // stessa ora
				if (lessons.get(i).docente != lessons.get(j).docente) { // se ha docenti diversi c'é
											// errore
				    violation2.add(lessons.get(i));
				}
			}
		    }
		}
	    }
	}
	System.out.println("Violazioni vincolo 2 : " + violation2.size());

	// - check VINCOLO 3
	// -######################################################################
	// calcolo il numero di lezioni che ha fatto un docente
	Collections.sort(lessons, new sortDocente());
	int violation3 = 0;
	for (int i = 0; i < lessons.size(); i++) {
	    HashSet<Lezione> lezioni_docente = new HashSet<Lezione>();
	    lezioni_docente.add(lessons.get(i));
	    for (int j = i + 1; (j < lessons.size()) && (lessons.get(i).docente == lessons.get(j).docente); j++) {
		// altre lezioni con lo stesso docente
		lezioni_docente.add(lessons.get(i));
	    }
	    if (lezioni_docente.size() < min_working_hours) {
		violation3++;	
	    }
	}
	System.out.println("Violazioni vincolo 3 : " + violation3);
	sc.close();
    }
}
