package removeDuplicates;
/**
 * Simple class that provides stop watch facility to monitor execution time.
 * 
 * @author tac
 *
 */
public class Timer {

	
	private final long NANO2MICRO = 1000;    // From nano to microseconds
	private final long NANO2MILLI = 1000000; // From nano to milliseconds
	
	private boolean started; // true if the timer was started
	private long    epoch;   // internal ticks when timer is started
	private long    elapsed; // elapsed ticks since the epoch (nanoseconds)
	
	/**
	 * Builds a timer object. 
	 */
	public Timer() {
		started = false;
		epoch = elapsed = 0;
	}
			
	/**
	 * Starts the timer. Once started the timer cannot be start again,
	 * but {@link Timer#stop() stop} must be used before
	 */
	public void start() {
		if (!started) {
			started = true;
			epoch = System.nanoTime();
		}	
	}	
			
	/**
	 * Stops the timer. Only a timer that was started with 
	 * {@link Timer#start() start} can be stopped.
	 */
	public void stop() {
		if (started) {
			started	= false;
			elapsed = System.nanoTime() - epoch;
		}	
	}	
			
	/**
	 * Returns the elapsed time since the start (in nanoseconds)
	 * 
	 * @return a long value 
	 */
	public long getElapsedNanoSeconds() {
		return elapsed;
	}				
		
	/**
	 * Returns the elapsed time since the start (in microseconds)
	 * 
	 * @return a long value
	 */
	public long getElapsedMicroSeconds() {
		return elapsed / NANO2MICRO;
	}
		

	/**
	 * Returns the elapsed time since the start (in milliseconds)
	 * 
	 * @return a long value
	 */
	public long getElapsedMilliSeconds() {
		return elapsed / NANO2MILLI;
	}
}
