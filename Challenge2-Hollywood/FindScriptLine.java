//UIUC CS125 FALL 2014 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T14:26:21-0500.464094257
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author qilezhi2
 */
public class FindScriptLine {

	public static void main(String[] args) {
// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
		
		boolean output = false;
		
		//Introduction
		TextIO.putln("Please enter the word(s) to search for");
		String word = TextIO.getln();
		TextIO.putln("Searching for '"+word+"'");
		
		//Read the file.
		TextIO.readFile("thematrix.txt"); 

		int count = 0;
		
		while ( ! TextIO.eof() ) {
			String line = TextIO.getln(); //Read the next line
			count++; //Count the lines.
			
			
			//Check all the upper and lower case, especially mix case.
			int n = word.length();
			String wordLower = word.toLowerCase();
			String wordUpper = word.toUpperCase();
			String initialLetter = String.valueOf(wordUpper.charAt(0));
			String otherLetter = wordLower.substring(1,n);
			String newLine = initialLetter + otherLetter;
			if (line.indexOf(word.toLowerCase()) >=0 || line.indexOf(word.toUpperCase()) >=0 || line.indexOf(newLine) >= 0) output = true;
			else output = false;
			
			//Skip all empty lines.
			if (line.length() == 0) output = false;
			
			//Print the line.
			if (output)
				TextIO.putln(count +" - "+line.trim());

		}
		TextIO.putln("Done Searching for '"+word+"'");
	}
}
