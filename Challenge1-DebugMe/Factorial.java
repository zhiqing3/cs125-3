//UIUC CS125 FALL 2014 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2015-09-07T22:42:37-0500.987639870

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author insert-your-netid-here
 */
public class Factorial {
	public static void main(String[] args) {
		int max = 0;
		System.out.println("Enter a number between 1 and 20 inclusive.");
		while (max < 1 || max >= 21) {
			max = TextIO.getlnInt();
		}
		TextIO.putln(42);
	}
}
