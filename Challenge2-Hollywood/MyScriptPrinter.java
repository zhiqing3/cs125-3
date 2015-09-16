//UIUC CS125 FALL 2014 MP. File: MyScriptPrinter.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T14:26:21-0500.464094257
/**
 * A program to print one actor's lines. 
 * See ScriptPrinter.txt for more information.
 * TODO: add your netid to the line below
 * @author qilezhi2
 */
public class MyScriptPrinter {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean output=false; //Set to true when we find the desired character
		String name=""; // Only print lines for this character
		
		//Name?
		TextIO.putln("Which character's lines would you like? (NEO,MORPHEUS,ORACLE)");
		name = TextIO.getln();
		String nameUpperCase = name.toUpperCase();

		//Read the file.
		TextIO.readFile("thematrix.txt"); // stop reading from the keyboard- use the script

		//TODO: Print the name here (see ScriptPrinter.txt example output for format)
		TextIO.putln(name.toUpperCase()+"'s lines:");
		
		output = false; // initially don't print anything

		// This loop will read one line at a time from the script until it
		// reaches the end of the file and then TextIO.eof() will return true.
		// eof means end-of-file
		while (! TextIO.eof()) {
			String line = TextIO.getln(); // Read the next line
			line = line.trim();
			//TODO: If it's a blank line set 'output' to false	
			//TODO: Correct the output format (see ScriptPrinter.txt example output)
			//TODO: Re-order the three if statements so the output is correct
			
			//Skip all empty lines.
			if (line.length() == 0) output = false;
			
			if (output) {
				TextIO.put(nameUpperCase+":\"");
				TextIO.put(line); // Only print the line if 'output' is true
				TextIO.putln("\"");
			}
			
			//This should be put in the end to avoid the line with name to be printed.
			if (line.indexOf(nameUpperCase) >= 0)
				output = true; // We found the character's name, time to start printing their lines

		}
		//TODO: Print 3 dashes here to indicate processing is complete
		TextIO.putln("---");
	}

}
