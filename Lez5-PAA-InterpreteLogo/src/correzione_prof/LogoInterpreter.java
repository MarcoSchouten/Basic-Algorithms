package correzione_prof;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LogoInterpreter {

    private static void executeProgram(Instruction[] program) {
	// Creates a new turtle to execute the program
	Turtle turtle = new Turtle();
	// For each instruction...
	for (Instruction command : program) {
	    switch (command.opCode) {
	    case Instruction.FORWARD:
		// Moving forward is a positive step
		turtle.move(command.argument);
		break;
	    case Instruction.BACK:
		// Moving backward is a negative step
		turtle.move(-1 * command.argument);
		break;
	    case Instruction.LEFT:
		// Counterclockwise rotation
		turtle.rotate(command.argument);
		break;
	    case Instruction.RIGHT:
		// Clockwise rotation
		turtle.rotate(-1 * command.argument);
		break;
	    case Instruction.PENUP:
		turtle.penDown = false;
		break;
	    case Instruction.PENDOWN:
		turtle.penDown = true;
		break;
	    default:
		throw new UnknownError("Ill formed instruction record");
	    }
	}
    }

    public static void main(String[] args) {
	if (args.length < 1) {
	    System.exit(0);
	}
	Parser parser = new Parser();
	Instruction[] program = null;
	try {
	    program = parser.parse(args[0]);
	} catch (FileNotFoundException e) {
	    System.out.println("File " + args[0] + " was not found! Exiting...");
	    System.exit(0);
	} catch (IOException e) {
	    System.out.println("Unexpected problem with file " + args[0] + "! Exiting...");
	}
	executeProgram(program);
	// The dialog pauses the program to visualize the canvas
	JOptionPane.showMessageDialog(null, "Program done!");
	// System.exit deallocates the graphic window which
	// remains "hanging" otherwise
	System.exit(0);

    }

}
