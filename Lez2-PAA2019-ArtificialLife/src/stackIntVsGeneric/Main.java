package stackIntVsGeneric;

/* 
 * ESERCIZIO - Consegna:
 * Confrontare le seguenti implementazioni dal punto di vista delle
 * prestazioni:
 * (1) I FixedSizeStackOfInt, ossia uno stack implementato con dati di tipo int;
 * (2) I FixedSizeStack, ossia uno stack parametrico.
 * 
 * L’obiettivo è quello di capire il costo associato al meccanismo
 * dell’autoboxing.
 * Autoboxing è il meccanismo automatico eseguito da Java che converte un tipo
 * primitivo in un tipo della classe Wrapper.
 * (es) int a --> Integer a     autoboing
 * (es) Integer a --> int a	unboxing
 * 
 * Quando applica autoboxing?
 * (1) quando il valore in è passato ad una funzione che aspetta Integer
 * (2) quando una variabile int è assegnata ad una classe wrapper
 * esempio quaando faccio nome_var++ ed è un integer,esso non dovrebbe 
 * funzionare perchè è un oggetto della classe Integer che non ha quel metodo, 
 * invece funziona perchè lo converte automaticamente (autboxing) invocando 
 * il metodo nome_valore.intVaulue().
 */

public class Main {

    public static void main(String[] args) {

	StackGeneric<Integer> genericStack = new StackGeneric<Integer>(50);
	StackOfInt stackOfInt = new StackOfInt(50);

	Timer t1 = new Timer();
	Timer t2 = new Timer();

	for (int i = 1; i <= 50; ++i) {
	    t1.start();
	    genericStack.push(i);
	    t1.stop();

	    t2.start();
	    stackOfInt.push(i);
	    t2.stop();

	    System.out.println(i + " " + t1.getElapsedNanoSeconds() + " " + t2.getElapsedNanoSeconds());
	}

    }

}
