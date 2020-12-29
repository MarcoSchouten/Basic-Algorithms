
public class Client {
    public static void main(String[] args) {
	/*
	 * Ragionamento con le liste Expression num1 = new Number(5); Expression num2 =
	 * new Number(3); Expression adds = new Add(num1, num2); Expression mults = new
	 * Mult(adds, num2); System.out.print("Il risultato vale " + mults.interpret());
	 */

	/* ragionamento con gli alberi */
	Parser p1 = new Parser();
	TreeExpr myTree = p1.parseExpression(args[0]); // crea l'albero
	System.out.print(myTree.root.E.interpret()); // calcola l'albero

    }
}
