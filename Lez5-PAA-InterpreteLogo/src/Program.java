import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private ArrayList<String> code;
    private int number_of_lines;
    private int index;

    /**
     * costruttore di default
     * 
     */
    Program() {
	this.code = new ArrayList<String>();
	this.number_of_lines = 0;
	this.index = 0;
    }

    /**
     * metodo: crea il programma leggendo da file
     * 
     * @param file_name
     * @throws FileNotFoundException
     */

    public void setCode(String file_name) throws FileNotFoundException {
	FileReader libro = new FileReader(file_name);
	Scanner lettore = new Scanner(libro);
	if (lettore.hasNext()) {
	    String s = new String(lettore.nextLine().trim());
	    number_of_lines = Integer.parseInt(s);
	}
	for (int i = 0; i < number_of_lines; i++) {
	    code.add(lettore.nextLine().trim());
	}
	lettore.close();
    }

    /**
     * get
     * 
     * @return
     */

    public ArrayList<String> getArray() {
	return code;
    }

    public int getNumber_of_lines() {
	return number_of_lines;
    }

    public boolean has_next() {
	return (this.index < this.number_of_lines);
    }

    public String getNextLine() {
	if (has_next()) {
	    index++;
	    return this.code.get(index - 1);
	} else
	    return null;
    }
}
