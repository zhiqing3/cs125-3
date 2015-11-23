//UIUC CS125 FALL 2014 MP. File: MazeRunner.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-11-17T19:51:09-0600.209811578
/**
 * @author qilezhi2
 */
public class MazeRunner {

	private int x, y;

	/** Initializes the MazeRunner with the x,y values */
	public MazeRunner(int x, int y) {	
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	/** Moves the runner one unit. No error checking is performed.
	 * 'N':go North (increment y), S:decrement y, E(increment x), W(decrement x)
	 * character values other than N,S,E or W are ignored.
	 */
	void moveOne(char dir) {
		if (dir=='N') y++;
		if (dir=='S') y--;
		if (dir=='E') x++;
		if (dir=='W') x--;
	}
	
	/** Returns true if this maze runner is on the same (x,y) square
	 * as the parameter. Assumes that the parameter is non-null.
	 */
	public boolean caught(MazeRunner other) {
		return this.x==other.x && this.y==other.y; 
	}

	/**
	 * Uses recursion to find index of the shortest string.
	 * Null strings are treated as infinitely long.
	 * Implementation notes:
	 * The base case if lo == hi.
	 * Use safeStringLength(paths[xxx]) to determine the string length.
	 * Invoke recursion to test the remaining paths (lo +1)
	 */
	static int findShortestString(String[] paths, int lo, int hi) {
		if (lo>=hi) return lo;
		else {
			if (paths[lo] != null && 
					safeStringLength(paths[lo]) < safeStringLength( paths[findShortestString(paths, lo+1, hi)] )) return lo;
			else return findShortestString(paths, lo+1, hi);
		}
	}

	/** Returns the length of the string or Integer.MAX_VALUE
	 * if the string is null.
	 * @param s
	 * @return
	 */
	static int safeStringLength(String s) {
		if (s==null) return Integer.MAX_VALUE;
		else return s.length();
	}

	/* Returns a string representation of the shortest path between
	 * (x,y) and (tx,ty). e.g. a result of "NNEE"
	 * means to travel from (x,y) -> (tx,ty) go North twice, then East twice.
	 * blocked is a square boolean grid of points that cannot be used.
	 * If(x,y) are invalid coords (outside of the grid array) this method returns null.
	 * If(x,y) is on a blocked square, this method returns null. Otherwise,
	 * If(x,y) are already the same as the target position, returns an empty string.
	 * If there is no path between (x,y) and (tx,ty) the method returns null.
	 * 
	 * Implementation notes:
	 * Use the statements above for the base cases.
	 * For the recursion part:
	 * 1. Set the current position to blocked (so that the recursive method does not
	 * attempt to re-use this square again)
	 * 2. Collect all paths from the NSEW neighbors
	 * 3. Reset the current blocked position to false.
	 * 4. Use findShortestString to determine the shortest path
	 * 5. If its non-null then PREPEND the compass direction of that neighbor's path.
	 * e.g. if the Northern neighbor returned "EWWS" 
	 * the East neighbor returned "NWWWWWWWSEEEESS" and W and S Neighbor return null
	 * then return "N" + "EWWS"
	 * Otherwise, just return null as none of the neighbors found a path.
	 */
	public static String shortestPath(int x, int y, int tX, int tY,
			boolean blocked[][]) {
		// Base cases.
		if (x<0 || x>blocked.length-1 || y<0 || y>blocked[0].length-1) return null;
		if (blocked[x][y]) return null;
		if (x==tX && y==tY) return "";
		
		blocked[x][y] = true; // Set the current position to blocked.
		String[] paths = {shortestPath(x, y+1, tX, tY, blocked), shortestPath(x, y-1, tX, tY, blocked), 
				shortestPath(x+1, y, tX, tY, blocked), shortestPath(x-1, y, tX, tY, blocked)}; // Collect all paths from the NSEW neighbors
		blocked[x][y] = false;
		
		if (paths[0]==null && paths[1]==null && paths[2]==null && paths[3]==null) return null;
		else {
			int i = findShortestString(paths, 0, 3); // Use findShortestString to determine the shortest path.
			if (i==0) return "N"+paths[i];
			if (i==1) return "S"+paths[i];
			if (i==2) return "E"+paths[i];
			else return "W"+paths[i];
		}
	}

	/** Moves the runner towards the target position, if the
	 * shortest path can be found between the current and target position.
	 * Implementation notes: calls shortestPath, 
	 * if result is not null then send the first char to moveOne()
	 * Hint: watch out for the empty string when target = current position...
	 */
	public void chase(boolean maze[][], int targetX, int targetY) {
		String s = shortestPath(this.x, this.y, targetX, targetY, maze);
		if (s==null) return;
		else if (s=="") return;
		else this.moveOne(s.charAt(0)); // Move the first step.
	}

}
