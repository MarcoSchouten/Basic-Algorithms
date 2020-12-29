package correzione_prof;

/**
 * Class to handle LOGO instructions
 * 
 * @author tac
 *
 */
public class Instruction {
    /**
     * Numeric code to identify empty argument list
     */
    public static final double NO_ARG = -1;

    /**
     * Numerical codes for instructions 
     */
    public static final int FORWARD = 0;
    public static final int BACK = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int PENUP = 4;
    public static final int PENDOWN = 5;

    /**
     * Opcode array such that OPCODE_MEMO[<opcode>] == "<opcode>" 
     */
    public static final String[] OPCODE_MEMO = { "FORWARD", "BACK", "LEFT", "RIGHT", "PENUP", "PENDOWN" };

    public int opCode; // These elements are public because the instruction
    public double argument; // is a simple record containing opcode and argument 

    /**
     * Statement constructor
     * 
     * @param opCode operational code (among the predefined ones)
     * @param argument argument (optional)
     */
    public Instruction(int opCode, double argument) {
	this.opCode = opCode;
	this.argument = argument;
    }
}
