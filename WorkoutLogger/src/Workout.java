/**
 * @author qilezhi2
 */
import java.util.Date;
	
public class Workout {

	private static int count=0;
	private static int countForDisplay=0; // Keep track when displaying workouts.
	private static Workout mostRecentWorkout = new Workout();
	
	
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
		countForDisplay = count; // Reset countForDisplay.
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
		
		// Enter a rating.
		while (mostRecentWorkout.rating<1 || mostRecentWorkout.rating>10) {
			TextIO.putln("Provide a rating to workout (1: great; 10 poor):");
			mostRecentWorkout.rating = TextIO.getlnInt(); // rating
		}
		TextIO.putln("Rating: " + mostRecentWorkout.rating);
		
		// Display result.
		TextIO.putln("\n--------------------------------");
		TextIO.putln("New workout has been created!");
		TextIO.putln(mostRecentWorkout.toString());
		TextIO.putln("--------------------------------\n");
	}
	
	
	public static void remove() {
		displayWorkouts();
		int input=0;
		while (input<1 || input>count) {
			TextIO.putln("Select an workout to delete :");
			input = TextIO.getlnInt();
		}
	}
	
	
	/* 
	 * [OPTION 3]
	 */
	public static void displayWorkouts() {
		TextIO.putln("\n--------------------------------");
		mostRecentWorkout.display();
		TextIO.putln("--------------------------------\n");
		countForDisplay = count; // Reset num.
	}
	
	public void display() {
		if (this.previous==null);
		else {
			TextIO.putln("No." + (count - countForDisplay + 1) + ". " + this.toString());
			countForDisplay--;
			this.previous.display();
		}
	}
	
	public String toString() {
		String s = "Location: " + this.location + ". ";
		if (this.buddy!="") s += "Buddy: " + this.buddy + ". ";
		s += "Starting Time: " + this.startingTime + ". ";
		s += "Duration: " + this.duration + ". ";
		s += "Rating: " + this.rating + ". ";
		return s;
	}
	
	
	/* 
	 * [MAIN METHOD]
	 */
	public static void main(String[] args) {
		boolean output = true;
		while (output) {
			TextIO.putln("\n--------------------------------");
			TextIO.putln("Welcome to the Workout Logger! Select an option below: \n");
			TextIO.putln("1) add a workout");
			TextIO.putln("2) remove a workout");
			TextIO.putln("3) display all workouts (listing should start with most recent)");
			TextIO.putln("4) display all workouts with buddy");
			TextIO.putln("5) display workouts for a certain location"); 
			TextIO.putln("(listing should be ordered by rating - best rated workout to lowest rated workout)");
			TextIO.putln("6) PB: display personal best time for a prompted location");
			TextIO.putln("7) quit\n");
			
			int input=0;
			while (input<1 || input>7) {
				TextIO.putln("Select an option above:");
				input = TextIO.getlnInt();
			}
			
			if (input == 1) add(); 
			if (input == 2) remove();
			if (input == 3) displayWorkouts();
			
			if (input == 7) {
				TextIO.putln("Are you sure you want to quit? - all your data will be lost. ");
				char inputChar = '?'; 
				while (inputChar != 'Y' && inputChar != 'N') {
					TextIO.putln("Y) Quit. N) Back");
					inputChar = TextIO.getlnChar(); 
				}	
				if (inputChar == 'Y') {
					TextIO.putln("Bye!");
					output = false;
				}
			}
			
		}
		
	}
	
}