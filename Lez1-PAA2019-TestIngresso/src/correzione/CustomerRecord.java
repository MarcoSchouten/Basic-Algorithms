package correzione;
	
public class CustomerRecord implements Comparable<CustomerRecord> {

    public int id;  
    public int value;
    
    public CustomerRecord(int id, int value) {
    	this.id = id;
        this.value = value;
    }
   
    public int compareTo(CustomerRecord other) {
    	return this.value - other.value;
    }
}


/*ha senso metterli pubblici perché non è possibile modificare il funzionamento dell'oggetto
strutture dati complesse che vedremo nel corso implica una possibile distruzione e hackeraggio 

*
* deve implementare il metodo comparable
* tutti gli algoritmi che assumono un'oggetto comparable
* qualsiasi classe che creiamo può essere resa sottoclasse dell'interfaccia compare to che permette di 
* confrontare qualsiasi oggetto
* 
* 
* 
* non è l'unico modo di ordinare degli oggetti
* */
