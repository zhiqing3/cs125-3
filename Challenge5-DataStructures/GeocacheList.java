//UIUC CS125 FALL 2014 MP. File: GeocacheList.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 * 
 * @author qilezhi2
 * 
 */
public class GeocacheList {
	private Geocache[] data = new Geocache[0];
	private int size = 0;

	public Geocache getGeocache(int i) {
		return this.data[i]; // return the i-th elements in the array
	}

	public int getSize() {
		return this.size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		this.size = other.size;
		if (deepCopy) { // deep copy
			this.data = new Geocache[other.data.length];
			for (int i=0; i<this.data.length; i++) this.data[i]=new Geocache(other.data[i]);
		}
		else {  // shallow copy
			this.data=other.data;
		}
	}

	public void add(Geocache p) {
		this.size++;
		if (this.size > this.data.length) {
			Geocache[] old = this.data;
			this.data = new Geocache[this.size];
			for (int i = 0; i < this.size-1; i++) this.data[i] = old[i];
		}
		this.data[this.size-1] = p;
	}

	public Geocache removeFromTop() {
		this.size--;
		Geocache[] old = this.data;
		this.data = new Geocache[this.size];
		for (int i = 0; i < this.size; i++) this.data[i] = old[i+1];
		return old[0];
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
	}	
}
