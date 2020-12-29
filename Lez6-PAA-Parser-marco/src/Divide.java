
public class Divide extends Expression {
    Expression exp1;
    Expression exp2;

    public Divide(Expression exp1, Expression exp2) {
	this.exp1 = exp1;
	this.exp2 = exp2;
    }

    @Override
    public int interpret() {
	return this.exp1.interpret() / this.exp2.interpret();
    }

}
