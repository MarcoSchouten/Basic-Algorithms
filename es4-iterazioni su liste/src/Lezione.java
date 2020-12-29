
public class Lezione {

    int docente;
    int aula;
    int giorno;
    int ora;

    public Lezione(int docente, int aula, int giorno, int ora) {
	this.docente = docente;
	this.aula = aula;
	this.giorno = giorno;
	this.ora = ora;
    }
    
   public void print() {
       System.out.print("("+ docente + " " + aula + " " +  giorno + " " +  ora + ")\n");
   
   }

}
