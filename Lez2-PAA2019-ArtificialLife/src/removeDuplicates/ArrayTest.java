package removeDuplicates;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class ArrayTest {
    // variabili
    private int[] array;
    private int token;

    // costruttore con parametro + stampa array array generato random
    public ArrayTest(int dimArray, int minBorder, int maxBorder) {
	array = new int[dimArray];
	token = minBorder - 1;
	System.out.print("L'arrayInput generato è ");
	for (int i = 0; i < array.length; i++) {
	    array[i] = StdRandom.uniform(minBorder, maxBorder);
	    System.out.print("[" + array[i] + "]");
	}
    }

    // FUNZIONE 1 - BRUTE FORCE ---------------------------------------
    public int[] removeDuplicatesBruteForce() {
	// 0 - array di copia
	int[] arrayInput = new int[array.length];
	int[] arrayOutput;
	int numberDuplicates = 0;
	for (int i = 0; i < array.length; i++)
	    arrayInput[i] = array[i];

	// 1 - metto un token alle celle da non segnare e li conto
	for (int i = 0; i < (arrayInput.length - 1); i++) {
	    for (int j = i + 1; j < arrayInput.length; j++) {
		if (arrayInput[i] != token && arrayInput[i] == arrayInput[j]) {
		    arrayInput[j] = token;
		    numberDuplicates++;
		}
	    }
	}

	// 2 - compilo il nuovo arrayInput scartando i
	int k = 0;
	arrayOutput = new int[arrayInput.length - numberDuplicates];
	for (int i = 0; i < (arrayInput.length); i++) {
	    if ((arrayInput[i] != token)) {
		arrayOutput[k] = arrayInput[i];
		k++;
	    }
	}
	return arrayOutput;
    }

    // FUNZIONE 2 - SORTING ---------------------------------------
    public int[] removeDuplicatesSorting() {
	// 0 - array di copia
	int[] arrayInput = new int[array.length];
	int[] arrayOutput;
	int numberDuplicates = 0;
	for (int i = 0; i < array.length; i++)
	    arrayInput[i] = array[i];

	// 1 - ordino array
	Arrays.sort(arrayInput);

	// 2 - tokenizzo i duplicati e li conto
	int j = 1;
	for (int i = 0; i < arrayInput.length; i++) {
	    j = i + 1;
	    while ((j < arrayInput.length) && arrayInput[i] != token && (arrayInput[i] == arrayInput[j])) {
		arrayInput[j] = token;
		numberDuplicates++;
		j++;
	    }
	}

	// 2 - compilo il nuovo arrayInput scartando i
	int k = 0;
	arrayOutput = new int[arrayInput.length - numberDuplicates];
	for (int i = 0; i < (arrayInput.length); i++) {
	    if ((arrayInput[i] != token)) {
		arrayOutput[k] = arrayInput[i];
		k++;
	    }
	}
	return arrayOutput;
    }
}