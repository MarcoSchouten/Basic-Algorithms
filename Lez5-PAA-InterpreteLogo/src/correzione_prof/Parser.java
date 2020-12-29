package correzione_prof;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Parser {

    public Instruction[] parse(String fileName) throws FileNotFoundException, IOException {

	FileReader textFileReader = new FileReader(fileName);
	Scanner in = new Scanner(textFileReader);

	int programLength = Integer.parseInt(in.nextLine().trim());
	Instruction[] program = new Instruction[programLength];

	for (int i = 0; i < programLength; ++i) {
	    // Get each line and split it into fields separated by space
	    String buffer = in.nextLine();
	    String fields[] = buffer.split(" ");

	    // The first field should be an opcode (FORWARD, BACK, etc.)
	    String opcode = fields[0].trim();
	    program[i] = null;
	    for (int op = Instruction.FORWARD; op <= Instruction.PENDOWN; ++op) {
		// Look for a match in the opcodes
		if (opcode.equals(Instruction.OPCODE_MEMO[op])) {
		    if (op == Instruction.PENDOWN || op == Instruction.PENUP) {
			// PENDOWN e PENUP do not have arguments
			program[i] = new Instruction(op, Instruction.NO_ARG);
		    } else {
			// Other opcodes have only one argument (second field)
			double argument = Double.NaN;
			try {
			    argument = Double.parseDouble(fields[1]);
			} catch (NumberFormatException e) {
			    in.close();
			    throw new ParseError("Cannot parse argument " + argument);
			}
			program[i] = new Instruction(op, argument);
		    }
		}
	    }
	    // If there was an invalid opcode program[i] is null
	    if (program[i] == null) {
		// Must avoid resource leak if an error is thrown
		in.close();
		throw new ParseError("Unknown opcode " + opcode);
	    }
	}

	in.close();
	textFileReader.close();

	return program;
    }
}
