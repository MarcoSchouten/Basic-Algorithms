
public class SyntaxError extends Exception {
    String error;

    public SyntaxError(String string) {
	error = string;
    }
}
