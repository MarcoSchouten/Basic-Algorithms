package stringVsStringBuffer;

import edu.princeton.cs.algs4.StdRandom;

/**
 * A simple class to compare performances of different methods to create a
 * string from an array of integers
 * 
 * @author tac
 *
 */
public class StringVsStringBuffer {

    /**
     * Fill an array with random integers
     * 
     * @param table the array to be filled
     */
    public static void fillWithRandomInts(int[] table) {
	for (int i = 0; i < table.length; ++i) {
	    table[i] = StdRandom.uniform(Integer.MAX_VALUE);
	}
    }

    /**
     * Tabulate an array of integers using String NOTE: inefficient in time and
     * memory
     * 
     * @param aTable table to be converted
     * @return the string containing all the values
     */
    public static String tabulateWithString(int[] aTable) {
	String result = new String();
	for (int i = 0; i < aTable.length; ++i) {
	    result = result + aTable[i] + "\n";
	}
	return result;
    }

    /**
     * Tabulate an array of integers using StringBuffer
     * 
     * @param aTable table to be converted
     * @return the string containing all the values
     */
    public static String tabulateWithStringBuffer(int[] aTable) {
	StringBuffer result = new StringBuffer();
	for (int i = 0; i < aTable.length; ++i) {
	    result.append(aTable[i] + "\n");
	}
	return result.toString();
    }

    /**
     * Tabulate an array of integers using StringBuilder
     * 
     * @param aTable table to be converted
     * @return the string containing all the values
     */
    public static String tabulateWithStringBuilder(int[] aTable) {
	StringBuilder result = new StringBuilder();
	for (int i = 0; i < aTable.length; ++i) {
	    result.append(aTable[i] + "\n");
	}
	return result.toString();
    }

    /**
     * Tabulate an array of integers using String.join
     * 
     * @param aTable table to be converted
     * @return the string containing all the values
     */
    public static String tabulateWithStringJoin(int[] aTable) {
	String[] temp = new String[aTable.length];
	for (int i = 0; i < aTable.length; ++i) {
	    temp[i] = Integer.toString(aTable[i]);
	}
	return String.join("\n", temp) + "\n";
    }

    /**
     * Runs the experiment: tabulate arrays filled with random integers of growing
     * size. Four different methods are tried.
     * 
     * @param args considers two arguments: maximum size and step
     */
    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Not enough arguments! Exiting...");
	    System.exit(0);
	}
	// Maximum lengths of the arrays to be generated
	int max = Integer.parseInt(args[0]);
	// Generation step
	int step = Integer.parseInt(args[1]);

	// Generate arrays from 'step' elements to 'max' elements
	for (int n = step; n < max; n += step) {

	    // Fill an array with random integers and set up a Timer
	    int[] table = new int[n];
	    fillWithRandomInts(table);
	    Timer timer = new Timer();

	    // Experiment 'tabulateWithString'
	    timer.start();
	    String message1 = tabulateWithString(table);
	    timer.stop();
	    long elapsed1 = timer.getElapsedMilliSeconds();

	    // Experiment 'tabulateWithStringBuffer'
	    timer.start();
	    String message2 = tabulateWithStringBuffer(table);
	    timer.stop();
	    long elapsed2 = timer.getElapsedMilliSeconds();

	    // Experiment 'tabulateWithStringBuilder'
	    timer.start();
	    String message3 = tabulateWithStringBuilder(table);
	    timer.stop();
	    long elapsed3 = timer.getElapsedMilliSeconds();

	    // Experiment 'tabulateWithStringBuilder'
	    timer.start();
	    String message4 = tabulateWithStringJoin(table);
	    timer.stop();
	    long elapsed4 = timer.getElapsedMilliSeconds();

	    // Print out results
	    System.out.println(n + " " + elapsed1 + " " + elapsed2 + " " + elapsed3 + " " + elapsed4);
	}

    }

}