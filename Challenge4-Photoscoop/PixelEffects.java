//UIUC CS125 FALL 2014 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-09-28T09:39:24-0500.547710265

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author qilezhi2
 */
public class PixelEffects {

	/* The representation of array: array[width][height]
	
	
	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		
		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height]; // Create a new 2D array of same size.
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) 
				result[i][j] = source[i][j]; // Copy the pointers.
		}

		return result; // Fix Me
	}
	
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		
		int width = source.length, height = source[0].length;
		int[][] result = new int[newWidth][newHeight]; // Create a new 2D array.
		double k = (double) newWidth / width; // Relative proportion
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				for (int a = (int) (k*i); a < (int) (k*(i+1)); a++) {
					for (int b = (int) (k*j); b < (int) (k*(j+1)); b++) 
						result[a][b] = source[i][j]; // Copy the pointers.
				}
			}
		}
		return result; // Fix Me
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return resize(source, source.length / 2, source[0].length / 2);// Fix Me
	}
	
	/**
	 * Create a new image array that is the same dimensions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		return resize(source, reference.length, reference[0].length); // Fix Me
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		
		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height]; // Create a new 2D array of same size.
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) 
				result[i][j] = source[i][height-1-j]; // Copy the pointers.
		}
		
		return result;// Fix Me
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		
		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height]; // Create a new 2D array of same size.
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) 
				result[i][j] = source[width-1-i][j]; // Copy the pointers.
		}
		
		return result;// Fix Me
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		
		int newHeight = source.length, newWidth = source[0].length; // The height of the new array is equal to the width of the source. 
																	// The width of the new array is equal to the height of the source.
		int[][] result = new int[newWidth][newHeight];
		
		for (int i = 0; i < newWidth; i++) {
			for (int j = 0; j < newHeight; j++) 
				result[i][j] = source[source.length-1-j][i]; // Copy the pointers.
		}
		
		return result;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel of the background).
		
		int width = sourceA.length, height = sourceA[0].length;
		int[][] result = new int[width][height]; // Create a new 2D array of same size.
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				// Get color for every element.
				int rgbA = sourceA[i][j];
				int rgbB = sourceB[i][j];
				int red = RGBUtilities.toRed(rgbA) + RGBUtilities.toRed(rgbB);
				if (red > 255) red = 255;
				int green = RGBUtilities.toGreen(rgbA) + RGBUtilities.toGreen(rgbB);
				if (green > 255) green = 255;
				int blue = RGBUtilities.toBlue(rgbA) + RGBUtilities.toBlue(rgbB);
				if (blue > 255) blue = 255;
				
				result[i][j] = RGBUtilities.toRGB(red, green, blue); // Copy the color.
			}
		}
		
		return result;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		
		int width = backImage.length, height = backImage[0].length;
		int[][] result = resize(foreImage, width, height); // Create a new 2D array of same size.
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				// Get color for every element.
				int rgb = foreImage[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				
				int rgb1 = backImage[i][j];
				int red1 = RGBUtilities.toRed(rgb1);
				int green1 = RGBUtilities.toGreen(rgb1);
				int blue1 = RGBUtilities.toBlue(rgb1);
				
				if (red > 4 * Math.max(green, blue) && red > 64) red = green = blue = 0; // Redeye
				
				if (green > Math.max(green, red)) result[i][j] = RGBUtilities.toRGB(red1, green1, blue1);
				else result[i][j] = RGBUtilities.toRGB(red, green, blue); // Copy the color.
			}
		}
		
		return foreImage;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		return null;
	}
}
