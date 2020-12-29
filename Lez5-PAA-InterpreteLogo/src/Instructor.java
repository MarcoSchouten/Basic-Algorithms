public class Instructor {
    private double intensity;
    private double angle;
    private Turtle franklin;
    private Program program;

    Instructor(Program program) {
	this.franklin = new Turtle();
	this.intensity = 0.0;
	this.angle = Math.PI / 2;
	this.program = program;
    }

    void compute_next_step() {
	// leggo una riga dal programma
	String str = new String(program.getNextLine());
	System.out.println("la riga appena letta vale:-" + str);
	String[] command = str.split(" ");

	// interpreto la riga che ho letto . posso fare la classe parse
	if (command[0].contentEquals("FORWARD")) {
	    intensity = intensity + Double.parseDouble(command[1]);
	}

	else if (command[0].contentEquals("BACK")) {
	    intensity = intensity - Double.parseDouble(command[1]);
	}

	else if (command[0].contentEquals("PENDOWN")) {

	    this.franklin.setActive();
	}

	else if (command[0].contentEquals("PENUP")) {
	    this.franklin.setInactive();
	}

	else if (command[0].contentEquals("LEFT")) {
	    angle = angle + Double.parseDouble(command[1]);

	}

	else if (command[0].contentEquals("RIGHT")) {
	    angle = angle - Double.parseDouble(command[1]);
	}
	// calcolo x e y finali
	double dx = intensity * Math.cos(Math.toRadians(angle));
	double dy = intensity * Math.sin(Math.toRadians(angle));
	double next_x = this.franklin.getX() + dx;
	double next_y = this.franklin.getY() + dy;

	// make franklin draw or move
	if (this.franklin.isActive()) {
	    this.franklin.draw_line_to(next_x, next_y);
	} else
	    this.franklin.set_position(next_x, next_y);

	// reset intensity, preserve angle
	this.intensity = 0.0;
    }

    boolean has_next_step() {
	return program.has_next();
    }

}
