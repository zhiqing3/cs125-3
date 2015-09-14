//UIUC CS125 FALL 2014 MP. File: ExampleInputOutput.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T14:26:21-0500.464094257
public class ExampleInputOutput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Formatted output
		double third = 1.0 / 3;
		TextIO.put("One third is ");
		TextIO.put(third);
		TextIO.putf(", or %.2f",third);
		TextIO.putln(" OK?");
		
		// A program that prints out if a number is odd or even
		// However it lies for some values...
		boolean oops = false;
		int a = 0;
		while (a <= 10) {
			oops = a >= 4 && a<=8;
			TextIO.put(a + " is ");
			if ((a % 2 == 1) || oops)
				TextIO.putln("Odd");
			else
				TextIO.putln("Even");
			a++;
		}

	}

}
