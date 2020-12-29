
public class Parser {

    public TreeExpr parseExpression(String S) {
	TreeExpr t = new TreeExpr();
	t.root = new NodeExpr();
	int i = recursiveParseExpression(S, 0, t.root);
	if (i < S.length()) {
	    System.out.print("sto facendo assert1");
	    assert true;
	}
	return t;
    }

    public int recursiveParseExpression(String S, int i, NodeExpr x) {
	String op = new String();

	if ((S.charAt(i) == '0') || (S.charAt(i) == '1') || (S.charAt(i) == '2') || (S.charAt(i) == '3')
		|| (S.charAt(i) == '4') || (S.charAt(i) == '5') || (S.charAt(i) == '6') || (S.charAt(i) == '7')
		|| (S.charAt(i) == '8') || (S.charAt(i) == '9')) {
	    return parseNumber(S, i, x);
	}

	else if (S.charAt(i) == '(') {
	    NodeExpr x_left = new NodeExpr();
	    i = recursiveParseExpression(S, i + 1, x_left);
	    // System.out.print(S.charAt(i));
	    if (S.charAt(i) != '+' && S.charAt(i) != '-' && S.charAt(i) != '/' && S.charAt(i) != '*') {
		System.out.print("sto facendo assert2");
		assert true;
	    } else {
		op = String.valueOf(S.charAt(i));
	    }
	    NodeExpr x_right = new NodeExpr();
	    i = recursiveParseExpression(S, i + 1, x_right);
	    if (S.charAt(i) != ')') {
		System.out.print("sto facendo assert3");
		assert true;

	    }

	    x.tag = "OPERATOR";
	    x.operator = op;
	    x.left = x_left;
	    x.right = x_right;
	    // System.out.print(x.operator);
	    switch (x.operator) {

	    case "+":
		x.E = new Add(x.left.E, x.right.E);
		break;
	    case "-":
		x.E = new Subtract(x.left.E, x.right.E);
		break;
	    case "/":
		x.E = new Divide(x.left.E, x.right.E);
		break;
	    case "*":
		x.E = new Mult(x.left.E, x.right.E);
		break;
	    default:
		break;
	    }
	    return i + 1;
	}

	else {
	    System.out.print("sto facendo assert4");
	    assert true;
	}
	return -1;
    }

    public int parseNumber(String S, int i, NodeExpr x) {
	int v = 0;
	if ((S.charAt(i) == '0') && ((S.charAt(i + 1) == '0') || (S.charAt(i + 1) == '1') || (S.charAt(i + 1) == '2')
		|| (S.charAt(i + 1) == '3') || (S.charAt(i + 1) == '4') || (S.charAt(i + 1) == '5')
		|| (S.charAt(i + 1) == '6') || (S.charAt(i + 1) == '7') || (S.charAt(i + 1) == '8')
		|| (S.charAt(i + 1) == '9'))) {
	    System.out.print("sto facendo assert5");
	    assert true;
	}
	// System.out.print(S.charAt(i) + " ");
	String app = new String(String.valueOf(S.charAt(i)));
	// System.out.print(app);
	v = Integer.parseInt(app);
	i = i + 1;
	// System.out.print(v);
	while (((S.charAt(i) == '0') || (S.charAt(i) == '1') || (S.charAt(i) == '2') || (S.charAt(i) == '3')
		|| (S.charAt(i) == '4') || (S.charAt(i) == '5') || (S.charAt(i) == '6') || (S.charAt(i) == '7')
		|| (S.charAt(i) == '8') || (S.charAt(i) == '9')) && i < S.length()) {
	    v = v * 10 + Integer.parseInt(String.valueOf(S.charAt(i)));
	    // System.out.print("sono nel loop while");
	}
	x.tag = "OPERAND";
	x.value = v;
	x.E = new Number(x.value);
	// System.out.print(x.value + " ");
	return i;
    }
}
