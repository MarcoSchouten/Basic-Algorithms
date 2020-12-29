import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class test {

    public static void main() throws IOException {
	FileReader f = new FileReader("input.txt");
	Scanner s = new Scanner(f);
	if (s.hasNext())
	    s.next();
	FileWriter f1 = new FileWriter("output.txt");
	PrintWriter p = new PrintWriter(f1);
	
    }

}
