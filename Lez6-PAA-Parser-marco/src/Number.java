
public class Number extends Expression {
    private int value;

    public Number(int value) {
	this.value = value;
    }

    @Override
    public int interpret() {
	return this.value;

    }

}
