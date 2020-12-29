import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

	Program program = new Program();
	program.setCode(args[0]);

	Instructor I = new Instructor(program);

	while (I.has_next_step()) {
	    I.compute_next_step();
	}

    }

}
