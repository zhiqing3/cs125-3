//UIUC CS125 FALL 2014 MP. File: StaticMethodsAreEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * @author qilezhi2
 */
public class StaticMethodsAreEasy {
// Oh no... Someone removed the methods but left the comments!!
// Hint: Get the Geocache class working and passing its tests first.

	/**
	 * Returns an array of num geocaches. Each geocache is initialized to a random
	 * (x,y) location.
	 * if num is less than zero, just return an empty array of length 0.
	 * 
	 * @param num
	 *            number of geocaches to create
	 * @return array of newly minted Points
	 */
	//write the method here...
	public static Geocache[] createGeocaches(int num) {
		if (num<0) return (new Geocache[0]);
		else {
			Geocache[] result = new Geocache[num];
			for (int i=0; i<num; i++) result[i]=new Geocache(Math.random()*10000,Math.random()*10000); // create new objects
			return result;
		}
	}
	
	/**
	 * Modifies geocaches if the geocache's X value is less than the allowable minimum
	 * value.
	 * 
	 * @param p
	 *            array of geocaches
	 * @param minX
	 *            minimum X value.
	 * @return number of modified geocaches (i.e. x values were too small).
	 */
	//write the method here...
	public static int ensureMinimumXValue(Geocache[] source, double minX) {
		int count=0;
		for (int i=0; i<source.length; i++) {
			// using accessor methods to access private instance variable x
			if (source[i].getX()<minX) { 
				source[i].setX(minX);
				count++;
			}
		}
		return count;
	}

	/**
	 * Counts the number of geocaches that are equal to the given geocache
	 * Hint: Use geocache.equals() method 
	 * @param p -
	 *            geocache array
	 * @param test -
	 *            test geocache (compared using .equal)
	 * @return number of matching geocaches
	 */
	//write the method here...
	public static int countEqual(Geocache[] sourceArray, Geocache source) {
		int count=0;
		for (int i=0; i<sourceArray.length; i++) {
			// using equals()
			if (sourceArray[i].equals(source)) count++;
		}
		return count;
	}
}
