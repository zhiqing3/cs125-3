//UIUC CS125 FALL 2014 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * @author qilezhi2
*/

public class Queue {
	private double[] queue = new double[0];
	
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		double[] old=queue;
		queue[0]=value;
		for (int i=1; i<queue.length+1; i++) queue[i]=old[i=1];
	}
	
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if (queue.length==0) return 0;
		else {
			double result=queue[queue.length-1];
			queue[queue.length-1]=0;
			return result;
		}
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		throw new RuntimeException("I am not a number; I am free man.");		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		throw new RuntimeException("The butler did it");
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		throw new RuntimeException("Daisy daisy daisy");
	}
}
