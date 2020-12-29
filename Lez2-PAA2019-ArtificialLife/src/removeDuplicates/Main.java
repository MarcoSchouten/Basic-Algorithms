package removeDuplicates;

public class Main {
    public static void main(String[] args) {
	// genero un array random
	ArrayTest arrayTest = new ArrayTest(1000, 0, 50);
	Timer timer = new Timer();

	// 1 - stampo array senza duplicati metodo Brute force
	System.out.println("\n \nMETODO BRUTE FORCE");

	timer.start();
	int[] arrayNoDuplicates = arrayTest.removeDuplicatesBruteForce();
	timer.stop();
	long elapsed1 = timer.getElapsedMilliSeconds();
	System.out.print("Il nuovo array senza duplicati è ");
	for (int i = 0; i < arrayNoDuplicates.length; i++) {
	    System.out.print("[" + arrayNoDuplicates[i] + "]");
	}
	System.out.print("\n");

	// 2 - stampo array senza duplicati metodo Sorting
	System.out.println("\nMETODO SORTING ");

	timer.start();
	arrayNoDuplicates = arrayTest.removeDuplicatesSorting();
	timer.stop();
	long elapsed2 = timer.getElapsedMilliSeconds();

	System.out.print("Il nuovo array senza duplicati è ");
	for (int i = 0; i < arrayNoDuplicates.length; i++) {
	    System.out.print("[" + arrayNoDuplicates[i] + "]");
	}

	System.out.println(" \n \n \n" + elapsed1 + " " + elapsed2);
    }
}