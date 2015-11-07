//UIUC CS125 FALL 2014 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2015-10-26T21:57:48-0500.725586880
/**
 * @author qilezhi2
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		if (gene1.length()==0 || gene2.length()==0) return 0; // Return 0 if at least one string is empty.
		char[] array1 = gene1.toCharArray();
		char[] array2 = gene2.toCharArray();
		return score(array1, array2, array1.length-1, array2.length-1);
		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
	}

	/** Implements longest common subsequence recursive search
	The recursive case is defined as
						S(i-1, j)
	S(i,j) = max {		S(i,j-1)
						S(i-1,j-1)
						S(i-1,j-1) +1 if gene1[i] = gene2[j]
	
	NB  0<=i < gene1.length
	    0<=j < gene2.length
	
	You need to figure out the base case.
	 * */
	public static int score(char[] a1, char[] a2, int i, int j) {
		if (i==0 || j==0) { 
			if (a1[i]==a2[j]) return 1; // If the length of at least one array is 1, the longest common sequence is at most 1.
			else {
				if (i>0 && j==0) return score(a1, a2, i-1, j);
				if (i==0 && j>0) return score(a1, a2, i, j-1);
				else return 0;
			}
		}
		else {
			if (a1[i]==a2[j]) return score(a1, a2, i-1, j-1) + 1;
			else return Math.max(score(a1, a2, i-1, j),score(a1, a2, i, j-1)); // score(i-1, j-1) is never bigger than the result.
		}
	}
//	define a private recursive Class method 'score' that 
//	returns an integer the score.
//	The method should take four parameters- 
//	two char arrays and two integers (gene1,gene2,i,j)
//	i and j are the indices into gene1 and gene2 respectively.

}
// Use local variables to store a recursive result so that you  do not need to calculate it again.

// Do not use a loops.
