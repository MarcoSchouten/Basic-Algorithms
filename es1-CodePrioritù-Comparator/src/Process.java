

public class Process {

    // member variables
    public int id;   // int > 0
    public int priority; // int
    public int residual_time; // int > 0 

    // member functions
    // constructor
    public Process(int id, int priority, int residual_time) {
	this.id = id;
	this.priority = priority;
	this.residual_time = residual_time;
    }
}
