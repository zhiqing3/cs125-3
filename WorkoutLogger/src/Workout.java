/**
 * @author qilezhi2
 */
import java.util.Date;
	
public class Workout {

	private static int count=0; // Count the number of workouts created.
	private static int tempCount=0; // Keep track when displaying workouts. For option 3 and 4.
	private static int num=0; // For option 4 and 5.
	private static Workout mostRecentWorkout = new Workout();
	
	public static Workout getMostRecentWorkoutPrevious() {return mostRecentWorkout.previous;}
	
	// Instance variables.
	private String location;
	private String buddy;
	private double milesCovered;
	private Date startingTime;
	private long duration;
	private int rating;
	private Workout previous;
	
	
	// Constructors
	public Workout() {};
	public Workout(String newLocation, String newBuddy, Workout newPrevious) {
		location = newLocation;
		buddy = newBuddy;
		previous = newPrevious;
		count++;
		tempCount = count; // Reset tempCount.
	}
	
	
	/* 
	 * [OPTION 1]
	 */
	public static void add() {
		
		// Enter a location.
		String newLocation = "";
		while (newLocation=="") {
			TextIO.putln("Enter a location.");
			newLocation = TextIO.getln(); // location.
		}
		TextIO.putln("Location: " + newLocation);
		
		// Enter a buddy.
		TextIO.putln("(Optional) Enter a buddy.");
		String newBuddy = TextIO.getln(); // buddy.
		
		// Create a new workout.
		Workout newWorkout = new Workout(newLocation, newBuddy, mostRecentWorkout);
		TextIO.putln("Buddy: " + newBuddy);
		mostRecentWorkout = newWorkout;
		
		// Start the workout.
		TextIO.put("Hit return to start workout:");
		TextIO.getln();
		mostRecentWorkout.startingTime = new Date(); // startingTime.
		TextIO.putln("Starting Time: " + mostRecentWorkout.startingTime);
		long start = System.currentTimeMillis();
		TextIO.put("Hit return to end workout:");
		TextIO.getln();
		TextIO.putln("Ending Time: " + new Date());
		long end = System.currentTimeMillis();
		mostRecentWorkout.duration = end - start; // duration.
		TextIO.putln("Duration: " + mostRecentWorkout.duration);
		
		// Enter milesCovered.
		while (mostRecentWorkout.milesCovered<=0) {
			TextIO.putln("Provide the miles covered:");
			mostRecentWorkout.milesCovered = TextIO.getDouble(); // rating
		}
		TextIO.putln("Miles Covered: " + mostRecentWorkout.milesCovered);
		
		// Enter a rating.
		while (mostRecentWorkout.rating<1 || mostRecentWorkout.rating>10) {
			TextIO.putln("Provide a rating to workout (1: great; 10 poor):");
			mostRecentWorkout.rating = TextIO.getlnInt(); // rating
		}
		TextIO.putln("Rating: " + mostRecentWorkout.rating);
		
		// Display result.
		TextIO.putln("\n--------------------------------");
		TextIO.putln("New workout has been created!");
		TextIO.put("NEW: "); // Just for alignment.
		mostRecentWorkout.printWorkout();
		TextIO.putln("--------------------------------");
	}
	
	
	/* 
	 * [OPTION 2]
	 */
	public static void remove() {
		displayWorkouts();
		int input=0;
		while (input<1 || input>count) {
			TextIO.putln("Select an workout to delete :");
			input = TextIO.getlnInt();
		}
		// Remove the specific workout.
		tempCount=input;
		if (tempCount==1) mostRecentWorkout = mostRecentWorkout.previous;
		else {
			tempCount--;
			mostRecentWorkout.removeOne();
		}
		tempCount = count; // Reset tempCount.
		TextIO.putln("The workout has been deleted!");
	}
	
	public void removeOne() {
		if (tempCount==1) this.previous = this.previous.previous;
		else {
			tempCount--;
			this.previous.removeOne();
		}
	}
	
	
	/* 
	 * [OPTION 3]
	 */
	public static void displayWorkouts() {
		TextIO.putln("\n--------------------------------");
		mostRecentWorkout.display();
		TextIO.putln("--------------------------------\n");
		tempCount = count; // Reset tempCount.
	}
	
	public void display() {
		if (this.previous==null); // Base case: the "previous" of the first workout.
		else {
			TextIO.put("No." + (count - tempCount + 1) + " ");
			this.printWorkout();
			tempCount--;
			this.previous.display();
		}
	}
	
//	public String toString() {
//		String s = "Location: " + this.location + ". ";
//		if (this.buddy!="") s += "Buddy: " + this.buddy + ". ";
//		s += "Starting Time: " + this.startingTime + ". ";
//		s += "Duration: " + this.duration + ". ";
//		s += "Rating: " + this.rating + ". ";
//		return s;
//	}
	
	public void printWorkout() {
		TextIO.put("[LOCATION     ] ");
		TextIO.putf("%28s", this.location); // Just for alignment.
		TextIO.putf("%5s", "");
		TextIO.put("[BUDDY   ] ");
		TextIO.putf("%15s", this.buddy); // Just for alignment.
		TextIO.putln();
		TextIO.putf("%5s", ""); // Just for alignment.
		TextIO.put("[STARTING TIME] " + this.startingTime);
		TextIO.putf("%5s", "");
		TextIO.put("[DURATION] ");
		TextIO.putf("%15s", this.duration);
		TextIO.putf("%5s", "");
		TextIO.put("[MILES COVERED] ");
		TextIO.putf("%15s", this.milesCovered);
		TextIO.putf("%5s", "");
		TextIO.put("[RATING] ");
		TextIO.putf("%2s", this.rating);
		TextIO.putln();
	}
	
	
	/* 
	 * [OPTION 4]
	 */
	public static void displayWorkoutBuddy(String newBuddy) {
		TextIO.putln("\n--------------------------------");
		mostRecentWorkout.displayBuddy(newBuddy);
		if (num==0) TextIO.putln("Sorry. No workouts are found.");
		TextIO.putln("--------------------------------");
		tempCount = count; // Reset tempCount.
		num = 0; // Reset num.
	}
	
	public void displayBuddy(String newBuddy) {
		if (this.previous==null); // Base case: the "previous" of the first workout.
		else {
			if (this.buddy.compareToIgnoreCase(newBuddy)==0) {
				TextIO.put("No." + (count - tempCount + 1) + " ");
				num++; // Count the number of workouts found.
				this.printWorkout();
			}
			tempCount--;
			this.previous.displayBuddy(newBuddy);
		}
	}
	
	
	/*
	 * [OPTION 5]
	 */
	public static void displayWorkoutLocation(String newLocation) {
		TextIO.putln("\n--------------------------------");
		for (int i=1; i<11; i++) {
			mostRecentWorkout.displayLocation(newLocation, i);
			tempCount = count; // Reset tempCount.
		}
		if (num==0) TextIO.putln("Sorry. No workouts are found.");
		TextIO.putln("--------------------------------");
		num = 0; // Reset num.
	}
	
	// Find the workout with rating of i. (i ranges from 1 to 10.)
	public void displayLocation(String newLocation, int i) {
		if (this.previous==null); // Base case: the "previous" of the first workout.
		else {
			if (this.location.compareToIgnoreCase(newLocation)==0 && this.rating==i) {
				TextIO.put("No." + (count - tempCount + 1) + " ");
				num++; // Count the number of workouts found.
				this.printWorkout();
			}
			tempCount--;
			this.previous.displayLocation(newLocation, i);
		}
	}
	
	
	/*
	 * [OPTION 6]
	 */
	public static void displayPB(double newMilesCovered) {
		TextIO.putln("\n--------------------------------");
		long target = mostRecentWorkout.getPB(newMilesCovered); // Get the PB.
		if (num==0) TextIO.putln("Sorry. No workouts are found.");
		else mostRecentWorkout.displayPB(newMilesCovered, target); // Display all workout with that duration.
		TextIO.putln("--------------------------------");
		tempCount = count; // Reset tempCount.
		num = 0; // Reset num.
	}
	
	public long getPB(double newMilesCovered) {
		if (this.previous.previous==null) { // Base case: the first workout.
			if (this.milesCovered==newMilesCovered) {
				num++; 
				return this.duration;
			}
			else return -1;
		}
		else {
			if (this.milesCovered==newMilesCovered) {
				num++; // // Count the number of workouts found.
				if (this.duration<this.previous.getPB(newMilesCovered)) return this.duration;
			}
			return this.previous.getPB(newMilesCovered);
		}
	}
	
	public void displayPB(double newMilesCovered, long target) {
		if (this.previous==null); // Base case: the "previous" of the first workout.
		else {
			if (this.duration==target && this.milesCovered==newMilesCovered) {
				TextIO.put("No." + (count - tempCount + 1) + " ");
				this.printWorkout();
			}
			tempCount--;
			this.previous.displayPB(newMilesCovered, target);
		}
	}
	
} // End of class
