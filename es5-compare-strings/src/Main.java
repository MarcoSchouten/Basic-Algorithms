import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// 0 - read input
	FileReader f1 = new FileReader(args[0]);
	FileReader f2 = new FileReader(args[1]);
	Scanner sc1 = new Scanner(f1);
	Scanner sc2 = new Scanner(f2);
	String[] text = sc1.nextLine().split(" ");
	String[] text2 = sc2.nextLine().split(" ");
	
	for (String s : text) {
	  System.out.print(s + " ");
	}
	System.out.println("");
	for (String s : text2) {
	    System.out.print(s + " ");
	}
	System.out.println("\n");

	// 1 - process input
	ArrayList<Integer> index = new ArrayList<Integer>();
	for (int i = 0; i < text.length; i++) {
	    if (!text[i].equals(text2[i])) {
		//System.out.println("-" + text[i] + "+" + text2[i] + "-");
		index.add(i);
	    }
	}
	for (Integer i : index) {
	    System.out.print(i + " ");
	}
	System.out.println("\n");

	for (int i = 0; i < index.size(); i++) {
	    System.out.print("1: ");
	    int original = i;
	    do {
		System.out.print(text[index.get(i)] + " ");
		i++;
	    } while (nextIsConsecutive(index, i));
	    i = original;
	    System.out.print("\n");
	    
	    System.out.print("2: ");
	    do {
		System.out.print(text2[index.get(i)] + " ");
		i++;
	    } while (nextIsConsecutive(index, i));

	    System.out.print("\n\n");
	    i--;
	}
	sc1.close();
	sc2.close();
    }

    private static boolean nextIsConsecutive(ArrayList<Integer> index, int next) {
	if (next >= index.size()) 
	    return false;
	else if (index.get(next-1) == index.get(next) - 1)
	    return true;
	else
	    return false;
    }
}