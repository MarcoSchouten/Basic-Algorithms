import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	FileReader f = new FileReader(args[0]);
	Scanner sc = new Scanner(f);
	Interpreter myInterpreter = new Interpreter();
	try {
	    while (sc.hasNext()) {
		String[] instruction = sc.nextLine().split(" ");
		myInterpreter.compute(instruction);
	    }
	} catch (SyntaxError e) {
	    e.printStackTrace();
	}
	sc.close();
    }
}
