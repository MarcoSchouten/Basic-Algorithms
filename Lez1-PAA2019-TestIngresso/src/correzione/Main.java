package correzione;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * LEGGERE SEMPRE IL FILE RIGA PER RIGA. toglie problemi di compatibilità tra diversi sistemi operativi.
 * in tutti gli homework e tutti gli esami c'è da leggere un file.
 * TRIM e SPLIT sono sempre utili negli scritti
 */

public class Main {
	/* qualsiasi eccezione viene lanciata al livello superiore: cioé la java virutual machine
	 * quindi il programma si interrompe.
	 * non è la strategia giusta
	 * */

	public static final void main (String args[]) throws Exception { 
		// EXit if no argument is given
		if (args.length == 0) {
			System.exit(0);
		}
		// Open input file and scanner
		String fileName = args[0];
		FileReader inputFileReader = new FileReader(fileName);
		Scanner inputFileScanner = new Scanner(inputFileReader);
		
		// 1 - Read the customer ID
		String line = inputFileScanner.nextLine();
		int customerId = Integer.parseInt(line.trim()); /* trim toglie gli spazi in eccesso */
		
		// 2 - Read the number of clients and products
		line  = inputFileScanner.nextLine();
		String[] fields = line.split(",");
		int customerNo =  Integer.parseInt(fields[0].trim());
		int productNo = Integer.parseInt(fields[1].trim());
		
		// 3 -  Read the customer data
		CustomerProfiles customerProfiles = 
				new CustomerProfiles(customerNo, customerNo);
		customerProfiles.readProfiles(inputFileScanner);
		
		// TODO: remove for final submission
		customerProfiles.dump();
		
		// close input file and scanner
		/* tutte le volte che non chiudo un file occupo un resourse descripiton che possono
		 * essere aperti solo in numero limtato.
		 * oppure non vedere salvati bene i dati
		 */
		inputFileScanner.close();
		inputFileReader.close();
		
		
		/* chiamare gli oggetti col nome della classe è un po' strano ma è un aiuto 
		 * altri lo potrebbero trovare fuorviante, ma non usare nomi cz */
		// 4 - Compute statistics
		CustomerStatistics customerStatistics = 
				new CustomerStatistics(customerId, customerProfiles);
		CustomerRecord[] results = customerStatistics.computeDistances();
		
		// 5 - Sort statistics and display results
		/* se dovete ordinare usate SEMPRE gli ordinamenti implementati in java perché 
		 * sono i più efficienti possibili 
		 * */
		Arrays.sort(results);
		for (CustomerRecord record : results) {
			System.out.println(record);
		}
		
		
	}
}
