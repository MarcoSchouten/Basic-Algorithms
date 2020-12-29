public class Coordinate {

    public int row;
    public int col;
    
    public Coordinate(int row, int col) {
	this.row = row;
	this.col = col;
    }
    
    public String toString() {
	return "(" + row + "," + col + ")";
    }
    
    public boolean equals(Coordinate c) {
	if (row == c.row && col == c.col)
	    return true;
	return false;
    }
}
