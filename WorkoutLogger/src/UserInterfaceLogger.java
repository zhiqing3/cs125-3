
public class UserInterfaceLogger {
	
	public static void main(String[] args) {
		
		boolean output = true;
		
		TextIO.putln("Welcome to the Workout Logger! Select an option below:");
		
		while (output) {
			
			TextIO.putln();
			TextIO.putln("1) add a workout");
			TextIO.putln("2) remove a workout");
			TextIO.putln("3) display all workouts (listing should start with most recent)");
			TextIO.putln("4) display all workouts with buddy");
			TextIO.putln("5) display workouts for a certain location"); 
			TextIO.putln("(listing should be ordered by rating - best rated workout to lowest rated workout)");
			TextIO.putln("6) PB: display personal best time for a prompted miles covered");
			TextIO.putln("7) quit\n");
			
			int input=0;
			while (input<1 || input>7) {
				TextIO.putln("Select an option above:");
				input = TextIO.getlnInt();
			}
			// If no workout exists..
			while (Workout.getMostRecentWorkoutPrevious()==null && input!=1 && input!=7) {
				TextIO.putln("No workouts exist. Please add a new workout or quit.");
				TextIO.putln("Select an option above:");
				input = TextIO.getlnInt();
			}
			
			if (input == 1) Workout.add(); 
			if (input == 2) Workout.remove();
			if (input == 3) Workout.displayWorkouts();
			
			if (input == 4) {
				TextIO.putln("Enter the name of the buddy.");
				String newBuddy = TextIO.getln();
				Workout.displayWorkoutBuddy(newBuddy);
			}
			
			if (input == 5) {
				TextIO.putln("Enter the name of the location.");
				String newLocation = TextIO.getln();
				Workout.displayWorkoutLocation(newLocation);
			}
			
			if (input == 6) {
				TextIO.putln("Enter the distance.");
				double newMilesCovered = TextIO.getDouble();
				Workout.displayPB(newMilesCovered);
			}
			
			if (input == 7) {
				TextIO.putln("Are you sure you want to quit? - all your data will be lost. ");
				char inputChar = '?'; 
				while (inputChar != 'Y' && inputChar != 'N' && inputChar != 'y' && inputChar != 'n') {
					TextIO.putln("Y) Quit. N) Back");
					inputChar = TextIO.getlnChar(); 
				}	
				if (inputChar == 'Y' || inputChar == 'y') {
					TextIO.putln("Bye!");
					output = false;
				}
			}
			
		} // End of while
		
	} // End of main

}
