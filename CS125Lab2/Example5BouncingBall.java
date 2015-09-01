//UIUC CS125 FALL 2014 MP. File: Example5BouncingBall.java, CS125 Project: CS125Lab2, Version: 2015-08-31T19:55:20-0500.292569650
public class Example5BouncingBall {
	/**
	 * Simulates bouncing a ball.
	 */
	public static void main(String[] args) {
		double x = 0;
		double y = 0;
		double velocityX = 1;
		double velocityY = 0;

		while (Zen.isRunning()) {
			Zen.fillOval((int) x, (int) y, 4, 4);
			Zen.sleep(20);
			velocityY = velocityY + 1;
			if (y + velocityY > 400)
				velocityY = -Math.abs(0.9 * velocityY);
			x = x + velocityX;
			y = y + velocityY;
		}
	}

}
