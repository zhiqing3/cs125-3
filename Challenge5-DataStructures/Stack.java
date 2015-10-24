//UIUC CS125 FALL 2014 MP. File: Stack.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * @author qilezhi2
*/

public class Stack {
	
	private String[] array = new String[0];
	
	/** Adds a value to the top of the stack.*/
	public void push(String value){
		String[] old = this.array;
		this.array = new String[old.length+1];
		this.array[old.length]= value; // Add the value to the top.
		for (int i=0; i<old.length; i++) this.array[i]=old[i]; // Copy others.
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if (this.isEmpty()) return null;
		else {
			String[] old = this.array;
			String result = this.array[old.length-1]; // The returned value is the top item of the array.
			this.array = new String[old.length-1];
			for (int i=0; i<old.length-1; i++) this.array[i]=old[i];
			return result;
		}
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if (this.isEmpty()) return null;
		else return this.array[this.array.length-1];
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return this.array.length==0;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return this.array.length;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String s = "";
		if (!this.isEmpty()) { // If the array is not empty
			for (int i=0; i<this.array.length; i++) s += this.array[i]+"\n"; // Every element is followed by \n.
		}
		return s;
	}
}
