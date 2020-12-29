import java.util.Comparator;

public class sortDocente implements Comparator<Lezione>{

    @Override
    public int compare(Lezione o1, Lezione o2) {
	if (o1.docente < o2.docente)
	    return -1;
	else return 
		1;

    }

}
