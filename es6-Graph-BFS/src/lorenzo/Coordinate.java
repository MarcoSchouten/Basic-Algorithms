package lorenzo;


public class Coordinate {
    private int riga;
    private int col;

    public Coordinate() {
	riga = 0;
	col = 0;
    }

    public Coordinate(int riga, int col) {
	this.riga = riga;
	this.col = col;
    }

    public int getRiga() {
	return riga;
    }

    public int getCol() {
	return col;
    }

    public boolean equals(Coordinate c) {
	if (riga == c.riga && col == c.col)
	    return true;
	return false;
    }
}
