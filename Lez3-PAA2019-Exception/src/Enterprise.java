import edu.princeton.cs.algs4.StdRandom;

public class Enterprise {
    private int id;
    private int budget;
    private int pay_buying_hours; // variabile aleatoria
    private int earn_selling_goods; // variabile aleatoria
    private int maxHours; // inizializzato da file
    private int efficiency; // inizializzato da file

    // costruttore
    Enterprise(int id, int startingBudget, int maxHours, int Efficiency) {
	this.setId(id);
	this.setBudget(startingBudget);
	this.efficiency = Efficiency;
	this.maxHours = maxHours;
	StdRandom.setSeed(0);
	this.pay_buying_hours = StdRandom.uniform(1, this.maxHours);
	this.earn_selling_goods = pay_buying_hours * efficiency;

    }

    // metodo 1 - set variabili aleatorie, chiamata per ogni ciclo
    void setRandomVariables() {
	this.pay_buying_hours = StdRandom.uniform(1, this.maxHours);
	this.earn_selling_goods = pay_buying_hours * efficiency;
    }

    // metodo 2 - get e set delle variabili
    int get_buying_hours() {
	return pay_buying_hours;
    }

    int get_selling_goods() {
	return earn_selling_goods;
    }

    public int getBudget() {
	return budget;
    }

    public void setBudget(int budget) {
	this.budget = budget;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}
