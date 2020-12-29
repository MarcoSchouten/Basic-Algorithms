package stringVsStringBuffer;

/**
 * Wrapper class to simplify access to memory statistics
 * 
 * @author tac
 *
 */
public class MemoryStats {

    private static final int MB = 1024 * 1024;

    private Runtime runtime;

    /**
     * Class constructor
     */
    public MemoryStats() {
	// Runtime class has a static method 'getRuntime()' that returns
	// a new object of the class Runtime ("factory method")
	// More details at:
	// http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html
	Runtime runtime = Runtime.getRuntime();
    }

    /**
     * Get the memory used by the current application
     * 
     * @return long value (used memory in megabytes)
     */
    public long getUsedMemory() {
	return (runtime.totalMemory() - runtime.freeMemory()) / MB;
    }

    /**
     * Get the free memory
     * 
     * @return long value (free memory in megabytes)
     */
    public long getFreeMemory() {
	return runtime.freeMemory() / MB;
    }

    /**
     * Get the total memory available (used + free)
     * 
     * @return long value (total memory in megabytes)
     */
    public long getTotalMemory() {
	return runtime.totalMemory() / MB;
    }

    /**
     * Get the maximum memory that can be allocated
     * 
     * @return long value (maximum memory the JVM will attempt to allocate)
     */
    public long getMaximumMemory() {
	return runtime.maxMemory() / MB;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
	StringBuffer result = new StringBuffer();

	result.append("Used memory:" + getUsedMemory() + "MB\n");

	// Memoria attualmente libera nella JVM
	result.append("Free memory:" + getFreeMemory() + "MB\n");

	// Memoria totale nella JVM
	result.append("Total memory:" + getTotalMemory() + "MB\n");

	// Memoria massima che la JVM può allocare
	result.append("Maximum memory:" + getMaximumMemory() + "MB\n");

	return result.toString();
    }

}
