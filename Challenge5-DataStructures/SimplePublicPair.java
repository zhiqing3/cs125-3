//UIUC CS125 FALL 2014 MP. File: SimplePublicPair.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/** A pair of public integers - the simplest kind of object
 * Normally we encapsulate the data and make it private.
 * Do not modify this file.
 * 
 * @author angrave
 * 
 */
public class SimplePublicPair {
	public int a;
	public int b;

	public void addOneToA() {
		this.a += 1;
	}

	public void addAPair(SimplePublicPair other) {
		this.a += other.a;
		this.b += other.b;
	}

	public boolean isLarger(SimplePublicPair other) {
		return this.a > other.a && this.b > other.b;
	}
}
