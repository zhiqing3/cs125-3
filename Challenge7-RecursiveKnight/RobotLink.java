//UIUC CS125 FALL 2014 MP. File: RobotLink.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-11-17T19:51:09-0600.209811578
/**
 * @author qilezhi2
 */
public class RobotLink {

	private RobotLink next; 	
	private final Robot robot;

	public Robot getRobot() {
		return robot;
	}
	
	/** Constructs this link.
	 * @param next ; the next item in the chain (null, if there are no more items).
	 * @param robot ; a single robot (never null).
	 */
	public RobotLink(RobotLink next,Robot robot) {
		this.robot = robot;
		this.next = next;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int count() {
		// BASE CASE; no more recursion required!
		if (next == null) return 1; 
		// Recursive case:
		return 1 + next.count();
	}
	
	/**
	 * Counts the number of flying robots in the linked list.
	 * Hint: robot.isFlying is useful here.
	 */
	public int countFlyingRobots() {
		// Base case
		if (next==null) {
			if (this.robot.isFlying()) return 1;
			else return 0;
		}
		// Recursive case
		else {
			if (this.robot.isFlying()) return 1 + next.countFlyingRobots();
			else return next.countFlyingRobots();
		}
	}
	
	/**
	 * Counts the number of flying robots upto and excluding a sad robot.
	 * (i.e. do not count the sad robot if it is flying).
	 * If there are no sad robots this function will return the same value as countFlyingRobots().
	 * Hint: robot.isHappy() is useful.
	 */
	public int countFlyingRobotsBeforeSadRobot() {
		if (!this.robot.isHappy()) return 0; // If the first robot is sad, just stop.
		// Base case: if the next is null, or if the next robot is sad
		if (next==null || (!this.next.robot.isHappy()) ) {
			if (this.robot.isFlying()) return 1;
			else return 0;
		}
		// Recursive case
		else {
			if (this.robot.isFlying()) return 1 + next.countFlyingRobotsBeforeSadRobot();
			else return next.countFlyingRobotsBeforeSadRobot();
		}
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param robot - the robot value of the new last link
	 */
	public void append(Robot robot) {
		if (next==null) next = new RobotLink(null, robot); // an new object
		else next.append(robot);
	}
	
	/**
	 * Returns the first flying unhappy robot, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getFirstFlyingUnhappyRobot() {
		boolean qualified = this.robot.isFlying() && (!this.robot.isHappy()); // flying and unhappy
		if (next==null) {
			if (qualified) return this.robot;
			else return null;
		}
		else {
			if (qualified) return this.robot;
			else return next.getFirstFlyingUnhappyRobot();
		}
	}
	
	/**
	 * Returns the last flying unhappy robot in the linked list, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getLastFlyingUnhappyRobot() {
		boolean qualified = this.robot.isFlying() && (!this.robot.isHappy()); // flying and unhappy
		if (next==null) {
			if (qualified) return this.robot;
			else return null;
		}
		else {
			if (qualified) {
				if (next.getLastFlyingUnhappyRobot() == null) return this.robot; // This robot is the last one qualified.
				else return next.getLastFlyingUnhappyRobot();
			}
			else return next.getLastFlyingUnhappyRobot();
		}
	}
	
	/**
	 * Returns a reference to the happy most distant explorer.
	 * Returns null if there are no happy robots
	 * @return reference to the most distant happy robot
	 */
	public Robot findHappyRobotFurthestFromHome() {
		if (next==null) {
			if (this.robot.isHappy()) return this.robot;
			else return null;
		}
		else {
			if (this.robot.isHappy()) {
				// This robot the farthest from home.
				if (this.robot.getDistanceFromHome() 
						> next.findHappyRobotFurthestFromHome().getDistanceFromHome()) return this.robot; 
				else return next.findHappyRobotFurthestFromHome();
			}
			else return next.findHappyRobotFurthestFromHome();
		}
	}
	
	/**
	 * Returns true if linked list contains the robot.
	 * Hint: Use robot.equals(other).
	 * @param robot
	 * @return
	 */
	public boolean contains(Robot other) {
		if (next==null) return this.robot.equals(other);
		else {
			if (this.robot.equals(other)) return true;
			else return this.next.contains(other);
		}
	}

	
}
