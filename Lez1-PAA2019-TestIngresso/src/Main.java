
/*
 * 1 aprire il file inserito come variabile dalla console
 * 2 leggere il file ed inserirlo in una struttura dati idonea
 * 3 computare la distanza per ciascun utente e salvare in un arraylist<customerREcord> facilmente ordinabile
 * 4 ordinare arraylist
 * 5 stampare a video
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final void main(String args[]) throws FileNotFoundException {
	if (args.length > 0) {
	    /* variabili */
	    int codiceUtente = 0;
	    int righe = 0;
	    int colonne = 0;
	    String line1;
	    String line2;
	    String[] righe_colonne;

	    /* apro il file */
	    String fileName = args[0];
	    FileReader inputFileReader = new FileReader(fileName);
	    Scanner inputFileScanner = new Scanner(inputFileReader);

	    /* leggere il file ed inserirlo in una struttura dati idonea */

	    /* leggo utente di riferimento */
	    line1 = inputFileScanner.nextLine();
	    codiceUtente = Integer.parseInt(line1.trim());

	    /* leggo numero di righe e colonne */
	    line2 = inputFileScanner.nextLine();
	    righe_colonne = line2.split(",");
	    righe = Integer.parseInt(righe_colonne[0].trim());
	    colonne = Integer.parseInt(righe_colonne[1].trim());

	    /* leggo la matrice */
	    int[][] dati = new int[righe][colonne];
	    for (int i = 0; i < righe; i++) {
		String line = inputFileScanner.nextLine();
		String[] fields = line.split(",");
		for (int j = 0; j < colonne; j++) {
		    dati[i][j] = Integer.parseInt(fields[j].trim());
		}
	    }
	    /*
	     * debug lettura for (int i = 0; i < righe; i++) { for (int j = 0; j < colonne;
	     * j++) System.out.print(dati[i][j]); System.out.println("Newline"); }
	     */

	    /* 3 computare la distanza per ciascun utente e salvare i dati un arraylist */

	    CustomerRecord[] comparisonData = new CustomerRecord[righe - 1];
	    int k = 0;
	    int distanza = 0;
	    for (int i = 0; i < righe; i++) {
		distanza = 0;
		if (i != codiceUtente - 1) {
		    for (int j = 0; j < colonne; j++) {
			distanza += Math.abs(dati[i][j] - dati[codiceUtente - 1][j]);
		    }
		    CustomerRecord temp = new CustomerRecord(i + 1, distanza);
		    comparisonData[k] = temp;
		    k++;
		}
	    }

	    /* ordino array di customer record */
	    Arrays.sort(comparisonData);
	    for (int i = 0; i < righe - 1; i++) {
		System.out.println(comparisonData[i].id + " " + comparisonData[i].value);
	    }
	    inputFileScanner.close();
	} else {
	    System.exit(9);
	}
    }
}
