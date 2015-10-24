//UIUC CS125 FALL 2014 MP. File: Geocache.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * Create a class 'Geocache' with two private instance variables 'x' 'y' of type double and a private integer 'id'
 * .
 * A class variable 'count' will also be required to count the number of times a Geocache object has been created (instantiated).
 * Create two constructors - one which takes two double parameters (the initial values of x,y). The
 * second constructor will take another Geocache and initialize itself based on that geocache.
 * 
 * For both constructors set the Geocache's id to the current value of count (thus the first geocache will have the value zero)
 * when the Geocache is created, then increment the count value. 
 * 
 * Also create 'resetCount()' and getNumGeocachesCreated() which returns an int - the number of geocaches created since 
 * resetCount() method was called.
 * 
 * Create an equals method that takes an object reference and returns true if the given object equals this object.
 * Hint: You'll need 'instanceof' and cast to a (Geocache)
 * 
 * Create a toString() method that returns a string representation of this object in the form '(x,y)' where 'x' and 'y'
 * are the current values of x,y.
 * 
 * Create the four getX/getY/setX/setY methods for x,y.
 * However the setX() method will only change the Geocache's x value if the given value is between -1000 and 1000 exclusive (i.e. -1000<x<1000).
 * If the value is outside of this range, the new value is ignored and the Geocache's x value remains unchanged.
 *   
 * Create a get method for id.
 * 
 * @author qilezhi2
 * 
 */
class Geocache {
	
	// Instance variables
	private double x;
	private double y;
	private int id;
	// Class variable
	private static int count; 
	
	// Constructors
	public Geocache(double newX, double newY) {
		this.x=newX;
		this.y=newY;
		this.id=count;
		count++; // Increment the count value
	}
	public Geocache(Geocache source) {
		this.x=source.x;
		this.y=source.y;
		this.id=count;
		count++; // Increment the count value
	}
	
	// Return the number of geocaches created since resetCount() method was called.
	public static void resetCount() {count=0;}
	public static int getNumGeocachesCreated() {return count;}
	
	// Return true if the given object equals this object
	public boolean equals(Object source) {
		if (source instanceof Geocache) {
			Geocache a = (Geocache)source;
			return this.x==a.x && this.y==a.y;
		}
		return false;
	}
	
	// Return a string representation of this object in the form '(x,y)'
	public String toString() {return "("+this.x+","+this.y+")";}
	
	// Accessor methods
	public void setX(double a) {if ( a<1000 && a>-1000 ) this.x=a;} // The setX() method will only change the Geocache's x value
																	// if the given value is between -1000 and 1000 exclusive
	public void setY(double a) {this.y=a;}
	public double getX() {return this.x;}
	public double getY() {return this.y;}
	public int getId() {return this.id;}
}
