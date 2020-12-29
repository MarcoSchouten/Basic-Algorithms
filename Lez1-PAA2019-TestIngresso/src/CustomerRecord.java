
public class CustomerRecord implements Comparable<CustomerRecord>{

    // -------------------- Variabili Membro --------------------------
    public int id;
    public int value;
    
    // -------------------- Metodi -----------------------------------  
    // #1 costruttore default
    public CustomerRecord() {
        this.id = 0;
        this.value = 0;
    }

    // #2 costruttore parametro
    public CustomerRecord(int id, int value) {
    	this.id = id;
        this.value = value;
    }
/*
    //#3 metodi get
    public int getId() {
        return this.id;
    }
    public int getValue() {
        return this.value;
    }
    
    // metodi set
 // #3 metodi set
    public void setId(int id) {
        this.id = id;
    }
    public void setValue(int value) {
        this.value = value;
    }
    */
   
    public int compareTo(CustomerRecord other) {
    	return this.value - other.value;
    }
}
