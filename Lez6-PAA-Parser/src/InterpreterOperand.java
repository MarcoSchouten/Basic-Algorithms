
public class InterpreterOperand implements InterpreterExpression {

	public int value;
	
	public InterpreterOperand(int value) {
		this.value = value;
	}
	
	public int evaluate() {
		return value;
	}
	
}
