package artificialLife;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Class to test Artificial Life simulator and understand garbage collection
 * internals
 * 
 * @author tac
 *
 */
public class TestArtificialLife {

    private static ArtificialLife world;

    private static String dumpStatistics(String header) {
	String message = header + "\n" + "Spawned Creature objects: " + Creature.getTotalIndividuals() + " \n"
		+ "Active Creature objects: " + Creature.getObjectCount() + " \n"
		+ (world != null ? "Creature objects in the simulator: " + world.getCreatureCount() + " \n" : "")
		+ "Active Food objects: " + Food.getObjectCount() + " \n"
		+ (world != null ? "Food objects in the simulator: " + world.getPastureCount() + " \n" : "");
	return message;
    }

    public static void main(String[] args) {
	world = new ArtificialLife(2, 5, 50);
	world.doSimulation();
	JOptionPane.showMessageDialog(null, "Simulation ended");

	String message = dumpStatistics("BEFORE forcing garbage collection");
	JTextArea textArea = new JTextArea();
	textArea.setText(message);
	JOptionPane.showMessageDialog(null, textArea);

	System.gc();

	message = dumpStatistics("AFTER forcing garbage collection");
	textArea.setText(message);
	JOptionPane.showMessageDialog(null, textArea);

	System.gc();

	message = dumpStatistics("AFTER the second forced garbage collection");
	textArea.setText(message);
	JOptionPane.showMessageDialog(null, textArea);

	world = null;
	System.gc();

	message = dumpStatistics("AFTER world=null and the third forced garbage collection");
	textArea.setText(message);
	JOptionPane.showMessageDialog(null, textArea);

	System.gc();

	message = dumpStatistics("AFTER world=null and the fourth forced garbage collection");
	textArea.setText(message);
	JOptionPane.showMessageDialog(null, textArea);

	System.exit(0);
    }

}
