import edu.princeton.cs.algs4.StdRandom;

public class Family {
    private int id;
    private int budget;
    private int earn_selling_hours; // variabile aleatoria
    private int pay_buying_goods; // variabile aleatoria
    private int maxGoodsPurchases; // limite
    private int maxWorkingHours; // limite

    // costruttore
    Family(int id, int startingBudget, int maxGoodsPurchases, int maxWorkingHours) {
	this.id = id;
	this.setBudget(startingBudget);
	this.maxGoodsPurchases = maxGoodsPurchases;
	this.maxWorkingHours = maxWorkingHours;
	StdRandom.setSeed(0);
	this.earn_selling_hours = StdRandom.uniform(1, this.maxWorkingHours);
	this.pay_buying_goods = StdRandom.uniform(1, this.maxGoodsPurchases);

    }

    // metodo 1 - set variabili aleatorie, chiamata per ogni ciclo
    void setRandomVariables() {
	this.earn_selling_hours = StdRandom.uniform(1, this.maxWorkingHours);
	this.pay_buying_goods = StdRandom.uniform(1, this.maxGoodsPurchases);
    }

    // metodo 2 - get
    int get_selling_hours() {
	return earn_selling_hours;
    }

    int get_buying_goods() {
	return pay_buying_goods;
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
