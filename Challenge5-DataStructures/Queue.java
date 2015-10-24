//UIUC CS125 FALL 2014 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * @author qilezhi2
*/

public class Queue {
	private double[] array = new double[0];
	
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		double[] old = this.array;
		this.array = new double[old.length+1];
		this.array[0]= value; // Add the value to the front.
		for (int i=0; i<old.length; i++) this.array[i+1]=old[i];
	}
	
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if (this.isEmpty()) return 0;
		else {
			double[] old = this.array;
			double result=this.array[old.length-1]; // The returned value is the last item of the array.
			this.array = new double[old.length-1];
			for (int i=0; i<old.length-1; i++) this.array[i]=old[i];
			return result;
		}
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return this.array.length;		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return this.array.length==0;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String s = "";
		// Reverse the order.
		for (int i=this.array.length-1; i>0; i--) s += this.array[i]+",";
		s += this.array[0];
		return s;
	}
}
