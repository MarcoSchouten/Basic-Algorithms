import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// Read files from input
	FileReader libro = new FileReader("input.txt");
	Scanner lettore = new Scanner(libro);
	int[] dati_input = new int[12];
	for (int i = 0; i < dati_input.length; i++) {
	    dati_input[i] = Integer.parseInt(lettore.nextLine().trim());
	}
	/*
	 * debug lettura corretta for (int x : dati) { System.out.print(x);
	 * System.out.print(","); }
	 */
	lettore.close();

	// step 1 - initialize
	// relizzo variabili aleatorie

	int number_cycles = dati_input[1];
	Family[] arr_fam = new Family[dati_input[2]];
	for (int i = 0; i < arr_fam.length; i++) {
	    arr_fam[i] = new Family(i, dati_input[6], dati_input[7], dati_input[8]);
	}
	Enterprise[] arr_enterp = new Enterprise[dati_input[3]];
	for (int i = 0; i < arr_enterp.length; i++) {
	    arr_enterp[i] = new Enterprise(i, dati_input[9], dati_input[10], dati_input[11]);
	}
	int counter = 0;

	do {
	    // step 1 - inizializzazione
	    // nuova realizzazione delle variabili aleatorie
	    for (Family f : arr_fam) {
		f.setRandomVariables();
	    }
	    for (Enterprise e : arr_enterp) {
		e.setRandomVariables();
	    }
	    // definisco i prezzi dei mercati, in funzione delle nuove variabili aleatorie
	    JobMarket job_market = new JobMarket(dati_input[5], arr_fam, arr_enterp);
	    GoodsMarket goods_market = new GoodsMarket(dati_input[4], arr_fam, arr_enterp);
	    int goods_price = goods_market.getPrice_final();
	    int hours_price = job_market.getPrice_final();

	    // step 2 - compute money change -- update()
	    // le famiglie
	    for (Family f : arr_fam) {
		int pagamento = f.get_buying_goods() * goods_price;
		int guadagno = f.get_selling_hours() * hours_price;
		int budget_inziale = f.getBudget();
		f.setBudget(budget_inziale + guadagno - pagamento);
	    }

	    // le imprese
	    for (Enterprise e : arr_enterp) {
		int pagamento = e.get_buying_hours() * hours_price;
		int guadagno = e.get_selling_goods() * goods_price;
		int budget_inziale = e.getBudget();
		e.setBudget(budget_inziale + guadagno - pagamento);
	    }

	    // stampa dei dati
	    System.out.println("INIZIO ITERAZIONE " + counter);
	    System.out.println("LAVORO domanda: " + job_market.get_tot_demand() + " offerta: "
		    + job_market.get_tot_supply() + " prezzo: " + job_market.getPrice_final());
	    System.out.println("BENI   domanda: " + goods_market.get_tot_demand() + " offerta: "
		    + goods_market.get_tot_supply() + " prezzo: " + goods_market.getPrice_final());
	    System.out.println("\n");
	    for (Family f : arr_fam) {
		System.out.println("Famiglia " + f.getId() + "; bilancio: " + f.getBudget());
	    }
	    for (Enterprise e : arr_enterp) {
		System.out.println("Impresa " + e.getId() + "; capitale: " + e.getBudget());
	    }
	    System.out.println("\n");
	    System.out.println("FINE ITERAZIONE " + counter);
	    System.out.println("\n");
	    counter++;

	} while (counter < number_cycles);
    }
}
