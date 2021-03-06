public class JobMarket {
    private int price_equilibrium;
    private int price_final;
    private int tot_supply;
    private int tot_demand;

    // constructor generates final price
    JobMarket(int price_equilibrium_goods, Family[] array_family, Enterprise[] array_enterprise) {
	this.price_equilibrium = price_equilibrium_goods;
	this.tot_demand = 0;
	this.tot_supply = 0;
	for (int i = 0; i < array_family.length; i++) {
	    this.tot_supply += array_family[i].get_selling_hours();
	}
	for (int i = 0; i < array_enterprise.length; i++) {
	    this.tot_demand += array_enterprise[i].get_buying_hours();
	}

	this.setPrice_final(this.price_equilibrium + (((tot_demand - tot_supply) * 100) / tot_demand));

    }

    // metodi set e get
    public int getPrice_final() {
	return price_final;
    }

    public void setPrice_final(int price_final) {
	this.price_final = price_final;
    }

    public int get_tot_supply() {
	return tot_supply;
    }

    public int get_tot_demand() {
	return tot_demand;
    }

}
