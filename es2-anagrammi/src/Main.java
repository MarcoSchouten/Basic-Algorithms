import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// 0 - leggo dati da file
	FileReader f = new FileReader("input.txt");
	Scanner sc = new Scanner(f);
	ArrayList<String> words = new ArrayList<String>();
	
	String[] input = sc.nextLine().split(" ");
	for (String s : input) {
	    words.add(s);
	}
	Collections.sort(words);
	

	// 1 - process
	for (int i = 0; i < words.size(); i++) {
	    ArrayList<String> anagrams = new ArrayList<String>();
	    for (int j = 0; j < words.size(); j++) {
		if (words.get(j) != words.get(i))
		    if (checkAnagrams(words.get(i), words.get(j))) 
			anagrams.add(words.get(j));
	    }
	    Collections.sort(anagrams);
	    System.out.print(words.get(i) + " "); // stampa parola
	    for (String anagram : anagrams) {
		System.out.print(anagram + " "); // stampa anagramma
	    }
	    System.out.print("\n"); // torna a capo
	}

	sc.close();
    }

    private static boolean checkAnagrams(String string, String string2) {
	if (string.length() != string2.length())
	    return false;

	String str = new String(string.toLowerCase());
	String str2 = new String(string2.toLowerCase());
	char[] s = str.toCharArray();
	char[] s2 = str2.toCharArray();

	Arrays.sort(s);
	Arrays.sort(s2);

	if (Arrays.equals(s, s2))
	    return true;

	return false;
    }
}
