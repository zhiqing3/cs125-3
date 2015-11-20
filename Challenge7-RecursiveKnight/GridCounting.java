//UIUC CS125 FALL 2014 MP. File: GridCounting.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-11-17T19:51:09-0600.209811578
/**
 * @author qilezhi2
 */
public class GridCounting {
	/** Returns the total number of possible routes (paths) from
	 * (x,y) to (tx,ty).
	 * There are only three valid kinds of moves:
	 *  Increment x by one.
	 *  Increment x by two.
	 *  Increment y by one.
	 *  
	 *  Hint: You'll need to test two base cases.
	 */
	public static int count(int x,int y, int tx, int ty) {
		if (x>tx || y>ty) return 0;
		if (x==tx) return 1; // y could only add 1, so there is only one solution.
		if (x==tx-1) { 
			if (y==ty) return count(x+1,y,tx,ty);
			else return count(x+1,y,tx,ty) + count(x,y+1,tx,ty);
		}
		else {
			if (y==ty) return count(x+1,y,tx,ty) + count(x+2,y,tx,ty);
			else return count(x+1,y,tx,ty) + count(x+2,y,tx,ty) + count(x,y+1,tx,ty);
		}
	}
}
