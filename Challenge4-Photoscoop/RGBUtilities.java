//UIUC CS125 FALL 2014 MP. File: RGBUtilities.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-09-28T09:39:24-0500.547710265
/* Manipulates RGB values
 * 
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author qilezhi2
 */

public class RGBUtilities {

/**
 * Extracts the red component (0..255)
 * Hint: see ch13.1.2 Working With Pixels 
 * http://math.hws.edu/javanotes/c13/s1.html#GUI2.1.2
 * 
 * ... also see the notes in READ-ME-FIRST
 * 
 * @param rgb the encoded color int
 * @return the red component (0..255)
 */
	public static int toRed(int rgb) {
		int red = (rgb/256/256) % 256; 
		return red; // FIX ME
	}

	public static int toGreen(int rgb) {
		int green = (rgb/256) % 256;
		return green; // FIX ME
	}

	public static int toBlue(int rgb) {
		int blue = rgb % 256;
		return blue; // FIX ME
	}

	/**
	 * 
	 * @param r the red component (0..255)
	 * @param g the green component (0..255)
	 * @param b the blue component (0..255)
	 * @return a single integer representation the rgb color (8 bits per component) rrggbb
	 */
	static int toRGB(int r, int g, int b) {
		return r*256*256 + g*256 + b; // FIX THIS
	}

}
