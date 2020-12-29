package correzione;

public class CustomerStatistics {

    private int customerId;
    private CustomerProfiles customerProfiles;

    // non ci sono altri costruttori
    // se mettiamo un costruttore in java c'é un solo modo per poter costruire
    // l'oggetto
    // imposta politica di utilizzo: deve dare l'id in fase di costruzione.
    // l'oggetto è specifico del costruttore e non può essere cambiato
    // è coerente con la responsabilità di questo oggetto definito nel diagramma su
    // DIa

    public CustomerStatistics(int customerId, CustomerProfiles customerProfiles) {
	this.customerId = customerId;
	this.customerProfiles = customerProfiles;
	/*
	 * se uso gli stessi nomi, per riferirmi all'attributo devo usare il this.
	 */
    }

    public CustomerRecord[] computeDistances() {
	// create an array to hold the results
	// the number of customers minus the profiled one
	int resultSize = customerProfiles.getSize() - 1;
	CustomerRecord[] result = new CustomerRecord[resultSize];

	// Extract the profile of "customerId"
	int[] pivotProfile = customerProfiles.getProfile(customerId);

	// For all profiles, computer the distance and store the result
	int j = 0;
	for (int id = 1; id <= customerProfiles.getSize(); j++) {
	    if (id != customerId) {
		int[] comparePRofile = customerProfiles.getProfile(id);
		int value = subtractArrays(pivotProfile, comparePRofile);
		result[j] = new CustomerRecord(id, value);
	    }
	}
	return result;
    }

    private int subtractArrays(int[] a, int[] b) {
	// TODO: implement
	return 0;
    }
}
