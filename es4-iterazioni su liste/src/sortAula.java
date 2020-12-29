import java.util.Comparator;

public class sortAula implements Comparator<Lezione>{

    @Override
    public int compare(Lezione o1, Lezione o2) {
	if (o1.aula < o2.aula)
	    return -1;
	else return 
		1;
    }
}
