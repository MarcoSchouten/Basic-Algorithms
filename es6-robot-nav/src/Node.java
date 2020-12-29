public class Node {
    
    
    private static int count = 0;
    public int id;
    public int row;
    public int col;
    
    public Node(int row, int col) {
	this.id = count++;
	this.row = row;
	this.col = col;
    }
    
    public String toString() {
	return "(" + row + "," + col + ")";
    }
    
   
    public boolean equals(Node c) {
	if (this.row == c.row && this.col == c.col)
	    return true;
	return false;
    }
    
   
}
