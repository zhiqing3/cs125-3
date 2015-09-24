//UIUC CS125 FALL 2014 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2015-09-20T22:31:37-0500.575882357
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author qilezhi2
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		
		line = line.toUpperCase(); // to upper case
		int length = line.length();
		
		// Count the alphabet.
		for (int i=0; i<26; i++) { // Check 26 letters separately.
			int countAlpha = 0;
			char alpha = (char) ('A' + i);
			for (int j=0; j<length; j++) {
				char c = line.charAt(j);
				if (c==alpha) countAlpha++;
			}
			if (countAlpha != 0) TextIO.putln(alpha + ":" + countAlpha);
		}
		
		int countNum = 0;
		int countSpace = 0;
		int countPunc = 0;
		for (int j=0; j<length; j++) {
			char c = line.charAt(j); // Read evry
			if (c<='9' && c>='0') countNum++; // Count digits.
			if (c == ' ') countSpace++; // Count spaces.
			if (c == '"' || c == '-' || c == '\'' || c == '.' || c == '!' || c == ',') countPunc++; // Count punctuation.
		}
		if (countNum != 0) TextIO.putln("DIGITS:" + countNum);
		if (countSpace != 0) TextIO.putln("SPACES:" + countSpace);
		if (countPunc != 0) TextIO.putln("PUNCTUATION:" + countPunc);
	}	
}
