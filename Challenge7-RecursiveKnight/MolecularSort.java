//UIUC CS125 FALL 2014 MP. File: MolecularSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-11-17T19:51:09-0600.209811578
public class MolecularSort {

	/** Sorts each xyz coordinate using it's Z value (coord[i][2] <= coord[j][2] for i<j). */
	static void sortCoordsByZ(double[][] coords) {
		// TODO: Implement this wrapper method.
		//All the work is performed by recursiveSort
	}

	/**
	 * recursively sorts coordinates entries by their z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static void recursiveSort(double[][] coords, int lo, int hi) {
		// TODO: write the four lines of a recursive selection sort here.
	}

	/**
	 * returns the index of the entry with the lowest Z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static int findIndexOfZMinimum(double[][] coords, int lo, int hi) {
		return lo; // TODO: Replace this with your three lines of recursive code
	}
	

	/* Swaps the (x,y and z) values of the i-th and j-th coordinates.*/
	static void swap(double[][] coords, int i, int j) {
		// TODO: write your swap implementation here
	}
}
