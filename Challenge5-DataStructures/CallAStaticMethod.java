//UIUC CS125 FALL 2014 MP. File: CallAStaticMethod.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:44:36-0500.940130950
/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 */
class CallAStaticMethod {

	public static void main(String[] args) {

		while (!TextIO.eof()) {
			String line = TextIO.getln();
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
			TextIO.putln(line);
		}

	}
}
