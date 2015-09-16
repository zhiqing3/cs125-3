//UIUC CS125 FALL 2014 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T14:26:21-0500.464094257
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author qilezhi2
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		// TODO: Write your program here
		// Hints :
		// Formatted output
		// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
		
		// Don't just copy paste the expected output
		// For grading purposes your code may be tested
		// with other input values.
		
		//Introduction
		TextIO.putln("Welcome. We're interested in how people are watching movies this year.");
		TextIO.putln("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		TextIO.putln("Please tell us about how you've watched movies in the last month.");
		
		int cinema;
		int dvdPlayer;
		int computer;
		
		//Questions: 
		TextIO.putln("How many movies have you seen at the cinema?");
		cinema = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a DVD or VHS player?");
		dvdPlayer = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a Computer?");
		computer = TextIO.getlnInt();
		
		//Print the summary.
		TextIO.putln("Summary: " + cinema + " Cinema movies, " + dvdPlayer + " DVD/VHS movies, " + computer + " Computer movies");
		int total = cinema + dvdPlayer + computer;
		TextIO.putln("Total: "+ total + " movies");
		
		//Print the fraction.
		double fractionOfCinema = (double) cinema/total;
		TextIO.put("Fraction of movies seen at a cinema: ");
		TextIO.putf("%.2f", 100*fractionOfCinema);
		TextIO.putln("%");
		
		double fractionOutside = 1 - fractionOfCinema;
		TextIO.put("Fraction of movies seen outside of a cinema: ");
		TextIO.putf("%.2f", 100*fractionOutside);
		TextIO.put("%");
		
	}
}
