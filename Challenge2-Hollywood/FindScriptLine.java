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
			
			String lineUpper = line.toUpperCase();
			if (lineUpper.indexOf(word.toUpperCase()) >=0) 
				TextIO.putln(count +" - "+line.trim());

		}
		TextIO.putln("Done Searching for '"+word+"'");
	}
}
