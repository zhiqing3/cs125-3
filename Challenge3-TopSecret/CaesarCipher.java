//UIUC CS125 FALL 2014 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2015-09-20T22:31:37-0500.575882357
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author qilezhi2
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		
		//TODO: Delete the following line and write your implementation here- 
		
		// Ask for the offset and check whether it is valid.
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		int offset = TextIO.getlnInt();
		while ( offset != 999 && offset != -999 && (offset==0 || offset>25 || offset<-25)) {
			TextIO.putln(offset + " is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			offset = TextIO.getlnInt();
		}
		
		if (offset == 999 || offset == -999) TextIO.putln("Using position shift");
		else TextIO.putln("Using shift value of " + offset);
		
		while (true) { // Run forever until the input is empty.
			
			// Ask for the line.
			TextIO.putln("Please enter the source text (empty line to quit)");
			String s = TextIO.getln();

			int length = s.length(); // Get the length 
		
			if (length == 0) break; // Stop when the input in empty.
			
			TextIO.putln("Source   :" + s); // Print the source.
			
			s = s.toUpperCase(); // Change the line to upper case.
			
			String newS = "";
			for (int i=0; i<length; i++) {
				char c = s.charAt(i); // Get the element in the line.
				char newC = c;
				if (c<'A' || c>'Z') newS += newC; // Punctuation and spaces are left unchanged.
				
				else {
					
					int j = i % 26;
					
					if (offset == 999) {
						newC = (char) (c + j);
					}
					else if (offset == -999) {
						newC = (char) (c - j);
					}
					
					else newC = (char) (c + offset); // Change the letter.
					
					// Remain newC between 'A' and 'Z'.
					while (newC<'A') {newC = (char) (newC + 26);}
					while (newC>'Z') {newC = (char) (newC - 26);}
					
					newS += newC; // Concatenation.
				}
				
			}
			
			TextIO.putln("Processed:"+newS);
			
		}
		
		// If the user enter an empty line, quit.
		TextIO.putln("Bye.");

	}

}