//UIUC CS125 FALL 2014 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-09-28T09:39:24-0500.547710265
/**
 * Add you netid here..
 * @author qilezhi2
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should work.
	 * Hint: Fix the formatting (shift-cmd-F) to help debug the following code
	 * @param list
	 * @param maximum
	 */
	public static void main(String[] arg) {
		int[] a = {0,1,2,3};
		int[] b = aa(a);
		System.out.print(b);
	}
	public static int[] aa(int[] source) {
		int[] c = source;
		c[0]=10;
		return c;
	}
	public static void list(String[] list, int maximum) {
		
		int i;
		if (maximum == -1) maximum = list.length; // If maximum is -1, print out all elements.
		
		for ( i = 0; i < maximum; i++) {
			TextIO.putln("" + (i+1) + ". " + list[i]);
		}
		
	}

	/**
	 * Appends or prepends the title
	 * @param list
	 * @param title
	 * @param prepend if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		
		String[] result = new String[list.length+1];
		
		if (prepend == true) {
			result[0] = title; // Prepend the title.
			for (int i = 1; i < result.length; i++) result[i] = list[i-1]; 
		}
		
		else{
			result[result.length-1] = title; // Append the title.
			for (int i = 0; i < result.length-1; i++) result[i] = list[i]; 
		}
		
		return result;
	}
	/**
	 * Returns a new list with the element at index removed.
	 * @param list the original list
	 * @param index the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		
		String[] result = new String[list.length-1];
		
		for (int i = 0; i < index; i++) result[i]=list[i]; // Copy pointers for i < index.
		for (int i = index; i < result.length; i++) result[i]=list[i+1]; // Copy pointers for i > index.
		
		return result;
	}

}
