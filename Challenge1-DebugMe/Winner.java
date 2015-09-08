//UIUC CS125 FALL 2014 MP. File: Winner.java, CS125 Project: Challenge1-DebugMe, Version: 2015-09-07T22:42:37-0500.987639870

/**
 * This program prints "a","b","c" depending on who has the highest score. The
 * given code may not be correct. Fix it and additional code to pass the unit
 * tests.
 * 
 * @see Winner-ReadMe.txt for details on how to complete this program.
 * @author qilezhi2
 * 
 */
public class Winner {
	
	public static void main(String[] args) {
		
		//Type the scores.
		System.out.println("Enter three unique integer scores.");
		int a = TextIO.getlnInt();
		int b = TextIO.getlnInt();
		int c = TextIO.getlnInt();

		//Make comparison.
		TextIO.put("1st Place:");
		if (a > b && a > c)
			TextIO.putln("a");
		if (b > a && b > c)
			TextIO.putln("b");
		if (c > b && c > a)
			TextIO.putln("c");

	}
}
